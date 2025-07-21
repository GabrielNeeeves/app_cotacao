package com.app_cotacao.app_cotacao.service;

import com.app_cotacao.app_cotacao.model.Cliente;
import com.app_cotacao.app_cotacao.model.Usuario;
import com.app_cotacao.app_cotacao.repository.ClienteRepository;
import com.app_cotacao.app_cotacao.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Criar cliente a partir de um id de usuario existente
    public Cliente createCliente(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com id: " + usuarioId));

        Cliente cliente = new Cliente(usuario);
        return clienteRepository.save(cliente);
    }

    public List<Cliente> getAllCLiente() {
        return clienteRepository.findAll();
    }

    // Buscar cliente por id_cliente (mesmo id do usuario)
    public Cliente getClienteById(Long idCliente) {
        return clienteRepository.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com id: " + idCliente));
    }

    // Atualizar cliente (exemplo: trocar o usuario associado)
    public Cliente updateCliente(Long idCliente, Long novoUsuarioId) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com id: " + idCliente));

        Usuario novoUsuario = usuarioRepository.findById(novoUsuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com id: " + novoUsuarioId));

        cliente.setUsuario(novoUsuario);
        cliente.setId_cliente(novoUsuario.getId_usuario());

        return clienteRepository.save(cliente);
    }

    // Deletar cliente
    public Cliente deleteCliente(Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com id: " + idCliente));

        clienteRepository.delete(cliente);
        return cliente;
    }
}
