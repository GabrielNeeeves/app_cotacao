package com.app_cotacao.app_cotacao.controller;

import com.app_cotacao.app_cotacao.model.Funcionario;
import com.app_cotacao.app_cotacao.service.FuncionarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    // POST /funcionarios?usuarioId=1&empresaId=2&escolaId=3
    @PostMapping
    public ResponseEntity<Funcionario> createFuncionario(
            @RequestParam Long usuarioId,
            @RequestParam Long empresaId,
            @RequestParam(required = false) Long escolaId) {
        Funcionario novo = funcionarioService.createFuncionario(usuarioId, empresaId, escolaId);
        return ResponseEntity.ok(novo);
    }

    // GET /funcionarios/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id) {
        try {
            Funcionario funcionario = funcionarioService.getFuncionarioById(id);
            return ResponseEntity.ok(funcionario);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT /funcionarios/{id}?usuarioId=...&empresaId=...&escolaId=...
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(
            @PathVariable Long id,
            @RequestParam(required = false) Long usuarioId,
            @RequestParam(required = false) Long empresaId,
            @RequestParam(required = false) Long escolaId) {
        try {
            Funcionario atualizado = funcionarioService.updateFuncionario(id, usuarioId, empresaId, escolaId);
            return ResponseEntity.ok(atualizado);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /funcionarios/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Funcionario> deleteFuncionario(@PathVariable Long id) {
        try {
            Funcionario deletado = funcionarioService.deleteFuncionario(id);
            return ResponseEntity.ok(deletado);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
