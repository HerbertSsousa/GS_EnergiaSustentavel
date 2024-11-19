package com.example.energia.controller;

import com.example.energia.dto.ViagemDTO;
import com.example.energia.service.ViagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/viagens")
public class ViagemController {

    @Autowired
    private ViagemService viagemService;

    @GetMapping
    public ResponseEntity<Page<EntityModel<ViagemDTO>>> listarViagens(Pageable pageable) {
        Page<ViagemDTO> viagens = viagemService.listarViagensPaginado(pageable);
        return ResponseEntity.ok(viagens.map(this::adicionarLinks));
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<EntityModel<ViagemDTO>>> listarViagensPorUsuario(@PathVariable Long idUsuario) {
        List<ViagemDTO> viagens = viagemService.listarViagensPorUsuario(idUsuario);
        return ResponseEntity.ok(viagens.stream().map(this::adicionarLinks).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ViagemDTO>> buscarViagemPorId(@PathVariable Long id) {
        ViagemDTO viagem = viagemService.buscarViagemPorId(id);
        return viagem != null ? ResponseEntity.ok(adicionarLinks(viagem)) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EntityModel<ViagemDTO>> salvarViagem(@RequestBody @Valid ViagemDTO viagemDTO) {
        ViagemDTO novaViagem = viagemService.salvarViagem(viagemDTO);
        return ResponseEntity.ok(adicionarLinks(novaViagem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarViagem(@PathVariable Long id) {
        viagemService.deletarViagem(id);
        return ResponseEntity.noContent().build();
    }

    private EntityModel<ViagemDTO> adicionarLinks(ViagemDTO viagemDTO) {
        EntityModel<ViagemDTO> viagemModel = EntityModel.of(viagemDTO);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ViagemController.class).buscarViagemPorId(viagemDTO.getIdViagem())).withSelfRel();
        viagemModel.add(selfLink);
        return viagemModel;
    }
}
