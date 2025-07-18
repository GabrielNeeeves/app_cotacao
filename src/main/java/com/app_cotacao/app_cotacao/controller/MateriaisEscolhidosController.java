package com.app_cotacao.app_cotacao.controller;

import com.app_cotacao.app_cotacao.model.MateriaisEscolhidos;
import com.app_cotacao.app_cotacao.model.fk_composta.MateriaisEscolhidosId;
import com.app_cotacao.app_cotacao.service.MateriaisEscolhidosService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materiais-escolhidos")
public class MateriaisEscolhidosController {

    @Autowired
    private MateriaisEscolhidosService service;

    // POST /materiais-escolhidos?clienteId=1&materialId=2
    @PostMapping
    public ResponseEntity<MateriaisEscolhidos> create(@RequestParam Long clienteId,
                                                      @RequestParam Long materialId) {
        MateriaisEscolhidos criado = service.create(clienteId, materialId);
        return ResponseEntity.ok(criado);
    }

    // GET /materiais-escolhidos?clienteId=1&materialId=2
    @GetMapping
    public ResponseEntity<MateriaisEscolhidos> getById(@RequestParam Long clienteId,
                                                       @RequestParam Long materialId) {
        MateriaisEscolhidosId id = new MateriaisEscolhidosId(clienteId, materialId);
        try {
            MateriaisEscolhidos me = service.getById(id);
            return ResponseEntity.ok(me);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /materiais-escolhidos?clienteId=1&materialId=2
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long clienteId,
                                       @RequestParam Long materialId) {
        MateriaisEscolhidosId id = new MateriaisEscolhidosId(clienteId, materialId);
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // GET /materiais-escolhidos/all
    @GetMapping("/all")
    public ResponseEntity<List<MateriaisEscolhidos>> findAll() {
        List<MateriaisEscolhidos> list = service.findAll();
        return ResponseEntity.ok(list);
    }
}
