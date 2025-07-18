package com.app_cotacao.app_cotacao.controller;

import com.app_cotacao.app_cotacao.model.ListaPropia_Material;
import com.app_cotacao.app_cotacao.service.ListaPropia_MaterialService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lista-propria-material")
public class ListaPropia_MaterialController {

    @Autowired
    private ListaPropia_MaterialService service;

    // POST /lista-propria-material?idListaPropria=1&idMaterial=2
    @PostMapping
    public ResponseEntity<ListaPropia_Material> create(
            @RequestParam Long idListaPropria,
            @RequestParam Long idMaterial) {
        ListaPropia_Material created = service.create(idListaPropria, idMaterial);
        return ResponseEntity.ok(created);
    }

    // GET /lista-propria-material?idListaPropria=1&idMaterial=2
    @GetMapping
    public ResponseEntity<ListaPropia_Material> getById(
            @RequestParam Long idListaPropria,
            @RequestParam Long idMaterial) {
        try {
            ListaPropia_Material found = service.getById(idListaPropria, idMaterial);
            return ResponseEntity.ok(found);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /lista-propria-material?idListaPropria=1&idMaterial=2
    @DeleteMapping
    public ResponseEntity<Void> delete(
            @RequestParam Long idListaPropria,
            @RequestParam Long idMaterial) {
        try {
            service.delete(idListaPropria, idMaterial);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
