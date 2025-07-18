package com.app_cotacao.app_cotacao.controller;

import com.app_cotacao.app_cotacao.model.Material;
import com.app_cotacao.app_cotacao.service.MaterialService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materiais")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    // POST /materiais
    @PostMapping
    public ResponseEntity<Material> createMaterial(@RequestBody Material material) {
        Material criado = materialService.createMaterial(material);
        return ResponseEntity.ok(criado);
    }

    // GET /materiais/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Material> getMaterialById(@PathVariable Long id) {
        try {
            Material mat = materialService.getMaterialById(id);
            return ResponseEntity.ok(mat);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT /materiais/{id}?nome=NovoNome
    @PutMapping("/{id}")
    public ResponseEntity<Material> updateMaterial(@PathVariable Long id, @RequestParam String nome) {
        try {
            Material atualizado = materialService.updateMaterial(id, nome);
            return ResponseEntity.ok(atualizado);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /materiais/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Material> deleteMaterial(@PathVariable Long id) {
        try {
            Material deletado = materialService.deleteMaterial(id);
            return ResponseEntity.ok(deletado);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
