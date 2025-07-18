package com.app_cotacao.app_cotacao.controller;

import com.app_cotacao.app_cotacao.model.ListaPropria;
import com.app_cotacao.app_cotacao.service.ListaPropriaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listas")
public class ListaPropriaController {

    @Autowired
    private ListaPropriaService listaPropriaService;

    // POST /listas?clienteId=1&nome=MinhaLista
    @PostMapping
    public ResponseEntity<ListaPropria> createLista(@RequestParam String nome,
                                                    @RequestParam Long clienteId) {
        ListaPropria nova = listaPropriaService.createListaPropria(nome, clienteId);
        return ResponseEntity.ok(nova);
    }

    // GET /listas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ListaPropria> getListaById(@PathVariable Long id) {
        try {
            ListaPropria lista = listaPropriaService.getListaPropriaById(id);
            return ResponseEntity.ok(lista);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // GET /listas
    @GetMapping
    public ResponseEntity<List<ListaPropria>> getAllListas() {
        List<ListaPropria> listas = listaPropriaService.getAllListas();
        return ResponseEntity.ok(listas);
    }

    // PUT /listas/{id}?nome=NovoNome
    @PutMapping("/{id}")
    public ResponseEntity<ListaPropria> updateLista(@PathVariable Long id,
                                                    @RequestParam String nome) {
        try {
            ListaPropria atualizado = listaPropriaService.updateListaPropria(id, nome);
            return ResponseEntity.ok(atualizado);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /listas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<ListaPropria> deleteLista(@PathVariable Long id) {
        try {
            ListaPropria deletado = listaPropriaService.deleteListaPropria(id);
            return ResponseEntity.ok(deletado);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
