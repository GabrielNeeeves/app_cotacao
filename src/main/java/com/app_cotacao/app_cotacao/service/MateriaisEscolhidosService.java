package com.app_cotacao.app_cotacao.service;

import com.app_cotacao.app_cotacao.model.Cliente;
import com.app_cotacao.app_cotacao.model.Material;
import com.app_cotacao.app_cotacao.model.MateriaisEscolhidos;
import com.app_cotacao.app_cotacao.model.fk_composta.MateriaisEscolhidosId;
import com.app_cotacao.app_cotacao.repository.ClienteRepository;
import com.app_cotacao.app_cotacao.repository.MaterialRepository;
import com.app_cotacao.app_cotacao.repository.MateriaisEscolhidosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaisEscolhidosService {

    @Autowired
    private MateriaisEscolhidosRepository materiaisEscolhidosRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MaterialRepository materialRepository;

    // Criar novo registro MateriaisEscolhidos
    public MateriaisEscolhidos create(Long clienteId, Long materialId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com id: " + clienteId));
        Material material = materialRepository.findById(materialId)
                .orElseThrow(() -> new EntityNotFoundException("Material não encontrado com id: " + materialId));

        MateriaisEscolhidos me = new MateriaisEscolhidos(cliente, material);
        return materiaisEscolhidosRepository.save(me);
    }

    // Buscar por id (chave composta)
    public MateriaisEscolhidos getById(MateriaisEscolhidosId id) {
        return materiaisEscolhidosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("MateriaisEscolhidos não encontrado para id: " + id));
    }

    // Deletar por id
    public void delete(MateriaisEscolhidosId id) {
        MateriaisEscolhidos me = getById(id);
        materiaisEscolhidosRepository.delete(me);
    }

    // Listar todos os registros
    public List<MateriaisEscolhidos> findAll() {
        return materiaisEscolhidosRepository.findAll();
    }

    // Não faz muito sentido um update direto nessa entidade pois é a relação entre cliente e material.
    // Se quiser atualizar, pode deletar e criar um novo registro.
}
