package com.app_cotacao.app_cotacao.service;

import com.app_cotacao.app_cotacao.model.ListaPropia_Material;
import com.app_cotacao.app_cotacao.model.ListaPropria;
import com.app_cotacao.app_cotacao.model.Material;
import com.app_cotacao.app_cotacao.model.fk_composta.ListaPropriaMaterialId;
import com.app_cotacao.app_cotacao.repository.ListaPropia_MaterialRepository;
import com.app_cotacao.app_cotacao.repository.ListaPropriaRepository;
import com.app_cotacao.app_cotacao.repository.MaterialRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListaPropia_MaterialService {

    @Autowired
    private ListaPropia_MaterialRepository listaPropiaMaterialRepository;

    @Autowired
    private ListaPropriaRepository listaPropriaRepository;

    @Autowired
    private MaterialRepository materialRepository;

    // Criar associação
    public ListaPropia_Material create(Long idListaPropria, Long idMaterial) {
        ListaPropria listaPropria = listaPropriaRepository.findById(idListaPropria)
                .orElseThrow(() -> new EntityNotFoundException("ListaPropria não encontrada com id: " + idListaPropria));

        Material material = materialRepository.findById(idMaterial)
                .orElseThrow(() -> new EntityNotFoundException("Material não encontrado com id: " + idMaterial));

        ListaPropia_Material entity = new ListaPropia_Material(listaPropria, material);
        return listaPropiaMaterialRepository.save(entity);
    }

    // Buscar por id composto
    public ListaPropia_Material getById(Long idListaPropria, Long idMaterial) {
        ListaPropriaMaterialId id = new ListaPropriaMaterialId(idListaPropria, idMaterial);
        return listaPropiaMaterialRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Associação não encontrada com id: " + id));
    }

    // Deletar associação
    public void delete(Long idListaPropria, Long idMaterial) {
        ListaPropriaMaterialId id = new ListaPropriaMaterialId(idListaPropria, idMaterial);
        ListaPropia_Material entity = listaPropiaMaterialRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Associação não encontrada com id: " + id));
        listaPropiaMaterialRepository.delete(entity);
    }
}
