package com.app_cotacao.app_cotacao.controller;

import com.app_cotacao.app_cotacao.model.Empresa;
import com.app_cotacao.app_cotacao.repository.EmpresaRepository;
import com.app_cotacao.app_cotacao.service.EmpresaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    // POST /empresas?nome=NomeEmpresa
    @PostMapping
    public ResponseEntity<Empresa> createEmpresa(@RequestParam String nome) {
        Empresa nova = empresaService.createEmpresa(nome);
        return ResponseEntity.ok(nova);
    }

    // GET /empresas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable Long id) {
        try {
            Empresa empresa = empresaService.getEmpresaById(id);
            return ResponseEntity.ok(empresa);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT /empresas/{id}?nome=NovoNome
    @PutMapping("/{id}")
    public ResponseEntity<Empresa> updateEmpresa(@PathVariable Long id,
                                                 @RequestParam String nome) {
        try {
            Empresa atualizada = empresaService.updateEmpresa(id, nome);
            return ResponseEntity.ok(atualizada);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /empresas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Empresa> deleteEmpresa(@PathVariable Long id) {
        try {
            Empresa deletada = empresaService.deleteEmpresa(id);
            return ResponseEntity.ok(deletada);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
