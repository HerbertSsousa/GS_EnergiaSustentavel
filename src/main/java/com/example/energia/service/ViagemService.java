package com.example.energia.service;

import com.example.energia.dto.ViagemDTO;
import com.example.energia.model.Usuario;
import com.example.energia.model.Viagem;
import com.example.energia.repository.UsuarioRepository;
import com.example.energia.repository.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ViagemService {

    @Autowired
    private ViagemRepository viagemRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<ViagemDTO> listarViagensPaginado(Pageable pageable) {
        Page<Viagem> viagens = viagemRepository.findAll(pageable);
        return viagens.map(this::convertToDTO);
    }

    public List<ViagemDTO> listarViagensPorUsuario(Long idUsuario) {
        List<Viagem> viagens = viagemRepository.findByUsuarioIdUsuario(idUsuario);
        return viagens.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ViagemDTO buscarViagemPorId(Long id) {
        Optional<Viagem> viagem = viagemRepository.findById(id);
        return viagem.map(this::convertToDTO).orElse(null);
    }

    public ViagemDTO salvarViagem(ViagemDTO viagemDTO) {
        Usuario usuario = usuarioRepository.findById(viagemDTO.getIdUsuario()).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        Viagem viagem = convertToEntity(viagemDTO);
        viagem.setUsuario(usuario);
        Viagem savedViagem = viagemRepository.save(viagem);
        return convertToDTO(savedViagem);
    }

    public void deletarViagem(Long id) {
        viagemRepository.deleteById(id);
    }

    private ViagemDTO convertToDTO(Viagem viagem) {
        ViagemDTO dto = new ViagemDTO();
        dto.setIdViagem(viagem.getIdViagem());
        dto.setIdUsuario(viagem.getUsuario().getIdUsuario());
        dto.setOrigem(viagem.getOrigem());
        dto.setDestino(viagem.getDestino());
        dto.setDataViagem(viagem.getDataViagem());
        dto.setDistanciaTotal(viagem.getDistanciaTotal());
        dto.setStatus(viagem.getStatus());
        return dto;
    }

    private Viagem convertToEntity(ViagemDTO dto) {
        Viagem viagem = new Viagem();
        viagem.setOrigem(dto.getOrigem());
        viagem.setDestino(dto.getDestino());
        viagem.setDataViagem(dto.getDataViagem());
        viagem.setDistanciaTotal(dto.getDistanciaTotal());
        viagem.setStatus(dto.getStatus());
        return viagem;
    }
}
