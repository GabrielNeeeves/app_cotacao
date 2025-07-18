package com.app_cotacao.app_cotacao.controller;

import com.app_cotacao.app_cotacao.model.Dependente;
import com.app_cotacao.app_cotacao.service.DependenteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dependentes")
public class DependenteController {

    @Autowired
    private DependenteService dependenteService;

    // POST /dependentes?clienteId=1
    @PostMapping
    public ResponseEntity<Dependente> createDependente(@RequestParam String nome, @RequestParam Long clienteId) {
        Dependente novo = dependenteService.createDependente(nome, clienteId);
        return ResponseEntity.ok(novo);
    }

    // GET /dependentes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Dependente> getDependenteById(@PathVariable Long id) {
        try {
            Dependente dep = dependenteService.getDependenteById(id);
            return ResponseEntity.ok(dep);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT /dependentes/{id}?nome=NovoNome
    @PutMapping("/{id}")
    public ResponseEntity<Dependente> updateDependente(@PathVariable Long id,
                                                       @RequestParam String nome) {
        try {
            Dependente atualizado = dependenteService.updateDependente(id, nome);
            return ResponseEntity.ok(atualizado);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /dependentes/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Dependente> deleteDependente(@PathVariable Long id) {
        try {
            Dependente deletado = dependenteService.deleteDependente(id);
            return ResponseEntity.ok(deletado);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}