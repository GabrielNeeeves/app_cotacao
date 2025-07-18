package com.app_cotacao.app_cotacao.controller;

import com.app_cotacao.app_cotacao.model.Escola;
import com.app_cotacao.app_cotacao.service.EscolaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/escolas")
public class EscolaController {

    @Autowired
    private EscolaService escolaService;

    // POST /escolas
    @PostMapping
    public ResponseEntity<Escola> createEscola(@RequestBody Escola novaEscola) {
        Escola criada = escolaService.createEscola(novaEscola);
        return ResponseEntity.ok(criada);
    }

    // GET /escolas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Escola> getEscolaById(@PathVariable Long id) {
        try {
            Escola escola = escolaService.getEscolaById(id);
            return ResponseEntity.ok(escola);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT /escolas/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Escola> updateEscola(@PathVariable Long id, @RequestBody Escola dadosAtualizados) {
        try {
            Escola atualizada = escolaService.updateEscola(id, dadosAtualizados);
            return ResponseEntity.ok(atualizada);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /escolas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Escola> deleteEscola(@PathVariable Long id) {
        try {
            Escola deletada = escolaService.deleteEscola(id);
            return ResponseEntity.ok(deletada);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}