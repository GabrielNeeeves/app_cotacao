package com.app_cotacao.app_cotacao.controller;

import com.app_cotacao.app_cotacao.model.ListaPadrao;
import com.app_cotacao.app_cotacao.service.ListaPadraoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listas-padrao")
public class ListaPadraoController {

    @Autowired
    private ListaPadraoService listaPadraoService;

    @PostMapping
    public ResponseEntity<ListaPadrao> createLista(@RequestBody ListaPadrao listaPadrao) {
        ListaPadrao criado = listaPadraoService.createListaPadrao(listaPadrao);
        return ResponseEntity.ok(criado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaPadrao> getListaById(@PathVariable Long id) {
        try {
            ListaPadrao lista = listaPadraoService.getListaPadraoById(id);
            return ResponseEntity.ok(lista);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ListaPadrao>> getAllListas() {
        List<ListaPadrao> listas = listaPadraoService.getAllListas();
        return ResponseEntity.ok(listas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaPadrao> updateLista(@PathVariable Long id, @RequestBody ListaPadrao dadosAtualizados) {
        try {
            ListaPadrao atualizado = listaPadraoService.updateListaPadrao(id, dadosAtualizados);
            return ResponseEntity.ok(atualizado);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLista(@PathVariable Long id) {
        try {
            listaPadraoService.deleteListaPadrao(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
