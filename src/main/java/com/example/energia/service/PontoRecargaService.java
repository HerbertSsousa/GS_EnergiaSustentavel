package com.example.energia.service;

import com.example.energia.dto.PontoRecargaDTO;
import com.example.energia.model.PontoRecarga;
import com.example.energia.repository.PontoRecargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PontoRecargaService {

    @Autowired
    private PontoRecargaRepository repository;

    public List<PontoRecargaDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PontoRecargaDTO buscarPorId(Long id) {
        PontoRecarga ponto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ponto de Recarga com ID " + id + " não encontrado."));
        return convertToDTO(ponto);
    }

    public PontoRecargaDTO criar(PontoRecargaDTO dto) {
        PontoRecarga ponto = convertToEntity(dto);
        repository.save(ponto);
        return convertToDTO(ponto);
    }

    public PontoRecargaDTO atualizar(Long id, PontoRecargaDTO dto) {
        PontoRecarga ponto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ponto de Recarga com ID " + id + " não encontrado."));
        ponto.setNome(dto.getNome());
        ponto.setEndereco(dto.getEndereco());
        ponto.setLatitude(dto.getLatitude());
        ponto.setLongitude(dto.getLongitude());
        ponto.setTipoConector(dto.getTipoConector());
        ponto.setPotenciaMaxima(dto.getPotenciaMaxima());
        ponto.setDisponibilidade(dto.getDisponibilidade());
        ponto.setPrecoPorKWh(dto.getPrecoPorKWh());
        repository.save(ponto);
        return convertToDTO(ponto);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Ponto de Recarga com ID " + id + " não encontrado.");
        }
        repository.deleteById(id);
    }

    private PontoRecargaDTO convertToDTO(PontoRecarga ponto) {
        PontoRecargaDTO dto = new PontoRecargaDTO();
        dto.setIdPontoRecarga(ponto.getIdPontoRecarga());
        dto.setNome(ponto.getNome());
        dto.setEndereco(ponto.getEndereco());
        dto.setLatitude(ponto.getLatitude());
        dto.setLongitude(ponto.getLongitude());
        dto.setTipoConector(ponto.getTipoConector());
        dto.setPotenciaMaxima(ponto.getPotenciaMaxima());
        dto.setDisponibilidade(ponto.getDisponibilidade());
        dto.setPrecoPorKWh(ponto.getPrecoPorKWh());
        return dto;
    }

    private PontoRecarga convertToEntity(PontoRecargaDTO dto) {
        PontoRecarga ponto = new PontoRecarga();
        ponto.setNome(dto.getNome());
        ponto.setEndereco(dto.getEndereco());
        ponto.setLatitude(dto.getLatitude());
        ponto.setLongitude(dto.getLongitude());
        ponto.setTipoConector(dto.getTipoConector());
        ponto.setPotenciaMaxima(dto.getPotenciaMaxima());
        ponto.setDisponibilidade(dto.getDisponibilidade());
        ponto.setPrecoPorKWh(dto.getPrecoPorKWh());
        return ponto;
    }
}
