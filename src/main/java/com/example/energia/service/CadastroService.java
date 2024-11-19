package com.example.energia.service;

import com.example.energia.dto.CadastroDTO;
import com.example.energia.model.Cadastro;
import com.example.energia.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository cadastroRepository;

    public List<CadastroDTO> listarTodos() {
        return cadastroRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<CadastroDTO> buscarPorId(Long id) {
        return cadastroRepository.findById(id).map(this::convertToDTO);
    }

    public CadastroDTO salvar(CadastroDTO cadastroDTO) {
        Cadastro cadastro = convertToEntity(cadastroDTO);
        return convertToDTO(cadastroRepository.save(cadastro));
    }

    public Optional<CadastroDTO> atualizar(Long id, CadastroDTO cadastroDTO) {
        return cadastroRepository.findById(id).map(cadastro -> {
            cadastro.setNome(cadastroDTO.getNome());
            cadastro.setEmail(cadastroDTO.getEmail());
            cadastro.setSenha(cadastroDTO.getSenha());
            cadastro.setTelefone(cadastroDTO.getTelefone());
            cadastro.setEndereco(cadastroDTO.getEndereco());
            return convertToDTO(cadastroRepository.save(cadastro));
        });
    }

    public void deletar(Long id) {
        cadastroRepository.deleteById(id);
    }

    private Cadastro convertToEntity(CadastroDTO dto) {
        Cadastro cadastro = new Cadastro();
        cadastro.setIdCadastro(dto.getIdCadastro());
        cadastro.setNome(dto.getNome());
        cadastro.setEmail(dto.getEmail());
        cadastro.setSenha(dto.getSenha());
        cadastro.setDataCadastro(dto.getDataCadastro());
        cadastro.setTelefone(dto.getTelefone());
        cadastro.setEndereco(dto.getEndereco());
        return cadastro;
    }

    private CadastroDTO convertToDTO(Cadastro entity) {
        CadastroDTO dto = new CadastroDTO();
        dto.setIdCadastro(entity.getIdCadastro());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        dto.setSenha(entity.getSenha());
        dto.setDataCadastro(entity.getDataCadastro());
        dto.setTelefone(entity.getTelefone());
        dto.setEndereco(entity.getEndereco());
        return dto;
    }


    public Page<CadastroDTO> listarTodos(int page, int size) {
        Page<Cadastro> pageResult = cadastroRepository.findAll(PageRequest.of(page, size));
        return pageResult.map(this::convertToDTO);
    }

}
