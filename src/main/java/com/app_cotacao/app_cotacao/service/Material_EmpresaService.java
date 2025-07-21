package com.app_cotacao.app_cotacao.service;

import com.app_cotacao.app_cotacao.model.Material_Empresa;
import com.app_cotacao.app_cotacao.model.fk_composta.MaterialEmpresaId;
import com.app_cotacao.app_cotacao.repository.Material_EmpresaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Material_EmpresaService {

    @Autowired
    private Material_EmpresaRepository repository;

    // Buscar todos
    public List<Material_Empresa> getAll() {
        return repository.findAll();
    }

    // Buscar por ID composto
    public Material_Empresa getById(MaterialEmpresaId id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("MaterialEmpresa não encontrado com id: " + id));
    }

    // Criar ou atualizar
    public Material_Empresa saveOrUpdate(Material_Empresa materialEmpresa) {
        return repository.save(materialEmpresa);
    }

    // Deletar
    public void delete(MaterialEmpresaId id) {
        Material_Empresa existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("MaterialEmpresa não encontrado com id: " + id));
        repository.delete(existing);
    }
}
