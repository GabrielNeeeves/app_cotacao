package com.app_cotacao.app_cotacao.service;

import com.app_cotacao.app_cotacao.model.ListaPadrao_Material;
import com.app_cotacao.app_cotacao.model.fk_composta.ListaPadraoMaterialId;
import com.app_cotacao.app_cotacao.repository.ListaPadrao_MaterialRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaPadrao_MaterialService {

    @Autowired
    private ListaPadrao_MaterialRepository listaPadraoMaterialRepository;

    // Criar ou atualizar (save funciona para ambos)
    public ListaPadrao_Material save(ListaPadrao_Material entity) {
        return listaPadraoMaterialRepository.save(entity);
    }

    // Buscar por id composto
    public ListaPadrao_Material getById(ListaPadraoMaterialId id) {
        return listaPadraoMaterialRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ListaPadrao_Material não encontrada para o id: " + id));
    }

    // Deletar por id composto
    public void deleteById(ListaPadraoMaterialId id) {
        ListaPadrao_Material entity = getById(id);
        listaPadraoMaterialRepository.delete(entity);
    }

    // Listar todos
    public List<ListaPadrao_Material> findAll() {
        return listaPadraoMaterialRepository.findAll();
    }
}
