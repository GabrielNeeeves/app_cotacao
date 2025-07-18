package com.app_cotacao.app_cotacao.controller;

import com.app_cotacao.app_cotacao.model.ListaPadrao_Material;
import com.app_cotacao.app_cotacao.model.fk_composta.ListaPadraoMaterialId;
import com.app_cotacao.app_cotacao.service.ListaPadrao_MaterialService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lista-padrao-material")
public class ListaPadrao_MaterialController {

    @Autowired
    private ListaPadrao_MaterialService service;

    // Listar todos
    @GetMapping
    public ResponseEntity<List<ListaPadrao_Material>> findAll() {
        List<ListaPadrao_Material> lista = service.findAll();
        return ResponseEntity.ok(lista);
    }

    // Buscar por id (chave composta via request params)
    @GetMapping("/buscar")
    public ResponseEntity<ListaPadrao_Material> getById(
            @RequestParam Long id_lista,
            @RequestParam Long id_material) {
        try {
            ListaPadraoMaterialId id = new ListaPadraoMaterialId(id_lista, id_material);
            ListaPadrao_Material entity = service.getById(id);
            return ResponseEntity.ok(entity);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Criar ou atualizar
    @PostMapping
    public ResponseEntity<ListaPadrao_Material> save(@RequestBody ListaPadrao_Material entity) {
        ListaPadrao_Material salvo = service.save(entity);
        return ResponseEntity.ok(salvo);
    }

    // Deletar por id composto (via request params)
    @DeleteMapping
    public ResponseEntity<Void> deleteById(
            @RequestParam Long id_lista,
            @RequestParam Long id_material) {
        try {
            ListaPadraoMaterialId id = new ListaPadraoMaterialId(id_lista, id_material);
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
