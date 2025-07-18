package com.app_cotacao.app_cotacao.service;

import com.app_cotacao.app_cotacao.model.Empresa;
import com.app_cotacao.app_cotacao.repository.EmpresaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    // Criar empresa
    public Empresa createEmpresa(String nome) {
        Empresa empresa = new Empresa(nome);
        return empresaRepository.save(empresa);
    }

    // Buscar por ID
    public Empresa getEmpresaById(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada com id: " + id));
    }

    // Atualizar nome da empresa
    public Empresa updateEmpresa(Long id, String novoNome) {
        Empresa empresaExistente = empresaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada com id: " + id));

        empresaExistente.setNome(novoNome);
        return empresaRepository.save(empresaExistente);
    }

    // Deletar empresa
    public Empresa deleteEmpresa(Long id) {
        Empresa empresaExistente = empresaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada com id: " + id));

        empresaRepository.delete(empresaExistente);
        return empresaExistente;
    }

}
