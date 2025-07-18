package com.app_cotacao.app_cotacao.service;

import com.app_cotacao.app_cotacao.model.Material;
import com.app_cotacao.app_cotacao.repository.MaterialRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public Material createMaterial(Material material) {
        return materialRepository.save(material);
    }

    public Material getMaterialById(Long id) {
        return materialRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Material não encontrado com id: " + id));
    }

    public Material updateMaterial(Long id, String novoNome) {
        Material materialExistente = materialRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Material não encontrado com id: " + id));

        materialExistente.setNome(novoNome);
        return materialRepository.save(materialExistente);
    }

    public Material deleteMaterial(Long id) {
        Material materialExistente = materialRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Material não encontrado com id: " + id));

        materialRepository.delete(materialExistente);
        return materialExistente;
    }
}
