package com.example.energia.service;

import com.example.energia.dto.ConfiguracaoCarroDTO;
import com.example.energia.model.ConfiguracaoCarro;
import com.example.energia.model.Usuario;
import com.example.energia.repository.ConfiguracaoCarroRepository;
import com.example.energia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConfiguracaoCarroService {

    @Autowired
    private ConfiguracaoCarroRepository configuracaoCarroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<ConfiguracaoCarroDTO> listarTodas() {
        return configuracaoCarroRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ConfiguracaoCarroDTO buscarPorId(Long id) {
        Optional<ConfiguracaoCarro> configuracaoCarro = configuracaoCarroRepository.findById(id);
        return configuracaoCarro.map(this::convertToDTO).orElseThrow(() -> new RuntimeException("Configuração não encontrada!"));
    }

    public ConfiguracaoCarroDTO salvar(ConfiguracaoCarroDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        ConfiguracaoCarro configuracaoCarro = convertToEntity(dto);
        configuracaoCarro.setUsuario(usuario);
        ConfiguracaoCarro salva = configuracaoCarroRepository.save(configuracaoCarro);

        return convertToDTO(salva);
    }

    public ConfiguracaoCarroDTO atualizar(Long id, ConfiguracaoCarroDTO dto) {
        ConfiguracaoCarro configuracaoCarro = configuracaoCarroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Configuração não encontrada!"));

        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        configuracaoCarro.setUsuario(usuario);
        configuracaoCarro.setCarroModelo(dto.getCarroModelo());
        configuracaoCarro.setAutonomiaCompleta(dto.getAutonomiaCompleta());
        configuracaoCarro.setConsumoPorKm(dto.getConsumoPorKm());

        ConfiguracaoCarro salva = configuracaoCarroRepository.save(configuracaoCarro);

        return convertToDTO(salva);
    }

    public void deletar(Long id) {
        if (!configuracaoCarroRepository.existsById(id)) {
            throw new RuntimeException("Configuração não encontrada!");
        }
        configuracaoCarroRepository.deleteById(id);
    }

    // Métodos auxiliares para conversão
    private ConfiguracaoCarroDTO convertToDTO(ConfiguracaoCarro entity) {
        ConfiguracaoCarroDTO dto = new ConfiguracaoCarroDTO();
        dto.setIdConfiguracaoCarro(entity.getIdConfiguracaoCarro());
        dto.setIdUsuario(entity.getUsuario().getIdUsuario());
        dto.setCarroModelo(entity.getCarroModelo());
        dto.setAutonomiaCompleta(entity.getAutonomiaCompleta());
        dto.setConsumoPorKm(entity.getConsumoPorKm());
        return dto;
    }

    private ConfiguracaoCarro convertToEntity(ConfiguracaoCarroDTO dto) {
        ConfiguracaoCarro entity = new ConfiguracaoCarro();
        entity.setCarroModelo(dto.getCarroModelo());
        entity.setAutonomiaCompleta(dto.getAutonomiaCompleta());
        entity.setConsumoPorKm(dto.getConsumoPorKm());
        return entity;
    }
}
