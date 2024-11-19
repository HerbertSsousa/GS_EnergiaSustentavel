package com.example.energia.controller;

import com.example.energia.dto.ConfiguracaoCarroDTO;
import com.example.energia.service.ConfiguracaoCarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configuracoes-carro")
public class ConfiguracaoCarroController {

    @Autowired
    private ConfiguracaoCarroService configuracaoCarroService;


    @GetMapping
    public ResponseEntity<List<ConfiguracaoCarroDTO>> listarTodas() {
        return ResponseEntity.ok(configuracaoCarroService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConfiguracaoCarroDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(configuracaoCarroService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ConfiguracaoCarroDTO> salvar(@RequestBody ConfiguracaoCarroDTO dto) {
        return ResponseEntity.ok(configuracaoCarroService.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConfiguracaoCarroDTO> atualizar(@PathVariable Long id, @RequestBody ConfiguracaoCarroDTO dto) {
        return ResponseEntity.ok(configuracaoCarroService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        configuracaoCarroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
