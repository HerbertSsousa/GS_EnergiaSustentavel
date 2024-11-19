package com.example.energia.controller;

import com.example.energia.dto.CadastroDTO;
import com.example.energia.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/cadastros")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;




    @GetMapping
    public ResponseEntity<List<CadastroDTO>> listarTodos() {
        List<CadastroDTO> cadastros = cadastroService.listarTodos();
        cadastros.forEach(c -> c.add(linkTo(methodOn(CadastroController.class).buscarPorId(c.getIdCadastro())).withSelfRel()));
        return ResponseEntity.ok(cadastros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CadastroDTO> buscarPorId(@PathVariable Long id) {
        return cadastroService.buscarPorId(id)
                .map(dto -> {
                    dto.add(linkTo(methodOn(CadastroController.class).listarTodos()).withRel("all-cadastros"));
                    return ResponseEntity.ok(dto);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CadastroDTO> salvar(@RequestBody CadastroDTO cadastroDTO) {
        CadastroDTO salvo = cadastroService.salvar(cadastroDTO);
        return ResponseEntity.created(linkTo(methodOn(CadastroController.class).buscarPorId(salvo.getIdCadastro())).toUri()).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CadastroDTO> atualizar(@PathVariable Long id, @RequestBody CadastroDTO cadastroDTO) {
        return cadastroService.atualizar(id, cadastroDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cadastroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
