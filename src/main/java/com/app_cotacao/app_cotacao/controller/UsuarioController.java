package com.app_cotacao.app_cotacao.controller;

import com.app_cotacao.app_cotacao.model.DTO.UsuarioDto;
import com.app_cotacao.app_cotacao.model.Usuario;
import com.app_cotacao.app_cotacao.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuario() {
        return usuarioService.getAllUsuario();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        try {
            Usuario usuario = usuarioService.getUsuarioById(id);
            return ResponseEntity.ok(usuario);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/post")
    public ResponseEntity<Usuario> createUsuario(@RequestBody UsuarioDto dto) {
        Usuario criado = usuarioService.createUsuario(dto);
        return ResponseEntity.ok(criado);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody UsuarioDto dto) {
        try {
            Usuario atualizado = usuarioService.updateUsuario(id, dto);
            return ResponseEntity.ok(atualizado);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable Long id) {
        try {
            Usuario deletado = usuarioService.deleteUsuario(id);
            return ResponseEntity.ok(deletado);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
