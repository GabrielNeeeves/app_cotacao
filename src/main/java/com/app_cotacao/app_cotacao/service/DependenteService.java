package com.app_cotacao.app_cotacao.service;

import com.app_cotacao.app_cotacao.model.Cliente;
import com.app_cotacao.app_cotacao.model.Dependente;
import com.app_cotacao.app_cotacao.repository.ClienteRepository;
import com.app_cotacao.app_cotacao.repository.DependenteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DependenteService {

    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Dependente createDependente(String nome, Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com id: " + clienteId));
        Dependente dependente = new Dependente(nome, cliente);
        return dependenteRepository.save(dependente);
    }

    public Dependente getDependenteById(Long id) {
        return dependenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dependente não encontrado com id: " + id));
    }

    public Dependente updateDependente(Long id, String novoNome) {
        Dependente dependenteExistente = dependenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dependente não encontrado com id: " + id));

        dependenteExistente.setNome(novoNome);
        return dependenteRepository.save(dependenteExistente);
    }

    public Dependente deleteDependente(Long id) {
        Dependente dependenteExistente = dependenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dependente não encontrado com id: " + id));

        dependenteRepository.delete(dependenteExistente);
        return dependenteExistente;
    }

}
