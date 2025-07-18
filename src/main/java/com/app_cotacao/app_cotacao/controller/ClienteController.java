package com.app_cotacao.app_cotacao.controller;

import com.app_cotacao.app_cotacao.model.Cliente;
import com.app_cotacao.app_cotacao.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // POST /clientes?usuarioId=1
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestParam Long usuarioId) {
        Cliente novo = clienteService.createCliente(usuarioId);
        return ResponseEntity.ok(novo);
    }

    // GET /clientes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        try {
            Cliente cliente = clienteService.getClienteById(id);
            return ResponseEntity.ok(cliente);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT /clientes/{id}?novoUsuarioId=2
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestParam Long novoUsuarioId) {
        try {
            Cliente atualizado = clienteService.updateCliente(id, novoUsuarioId);
            return ResponseEntity.ok(atualizado);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /clientes/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable Long id) {
        try {
            Cliente deletado = clienteService.deleteCliente(id);
            return ResponseEntity.ok(deletado);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

}
