package com.app_cotacao.app_cotacao.service;

import com.app_cotacao.app_cotacao.model.DTO.UsuarioDto;
import com.app_cotacao.app_cotacao.model.Usuario;
import com.app_cotacao.app_cotacao.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuario() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Long usuarioId) {
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com id: " + usuarioId));
    }

    public Usuario createUsuario(UsuarioDto usuarioDto) {
        Usuario usuarioNovo = new Usuario(usuarioDto);
        return usuarioRepository.save(usuarioNovo);
    }

    public Usuario deleteUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com id: " + usuarioId));

        usuarioRepository.delete(usuario);
        return usuario;
    }

    public Usuario updateUsuario(Long usuarioId, UsuarioDto dto) {
        Usuario usuarioExistente = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com id: " + usuarioId));

        usuarioExistente.setNome(dto.nome());
        usuarioExistente.setEmail(dto.email());
        usuarioExistente.setSenha(dto.senha());
        usuarioExistente.setRole(dto.role());

        return usuarioRepository.save(usuarioExistente);
    }
}
