package com.app_cotacao.app_cotacao.service;

import com.app_cotacao.app_cotacao.model.Cliente;
import com.app_cotacao.app_cotacao.model.ListaPropria;
import com.app_cotacao.app_cotacao.repository.ClienteRepository;
import com.app_cotacao.app_cotacao.repository.ListaPropriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaPropriaService {

    @Autowired
    private ListaPropriaRepository listaPropriaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    // Criar nova ListaPropria
    public ListaPropria createListaPropria(String nome, Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com id: " + clienteId));

        ListaPropria lista = new ListaPropria(nome, cliente);
        return listaPropriaRepository.save(lista);
    }

    // Buscar por id
    public ListaPropria getListaPropriaById(Long id) {
        return listaPropriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ListaPropria não encontrada com id: " + id));
    }

    // Listar todas
    public List<ListaPropria> getAllListas() {
        return listaPropriaRepository.findAll();
    }

    // Atualizar nome
    public ListaPropria updateListaPropria(Long id, String novoNome) {
        ListaPropria listaExistente = listaPropriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ListaPropria não encontrada com id: " + id));

        listaExistente.setNome(novoNome);
        return listaPropriaRepository.save(listaExistente);
    }

    // Deletar
    public ListaPropria deleteListaPropria(Long id) {
        ListaPropria listaExistente = listaPropriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ListaPropria não encontrada com id: " + id));

        listaPropriaRepository.delete(listaExistente);
        return listaExistente;
    }
}
