package com.app_cotacao.app_cotacao.service;

import com.app_cotacao.app_cotacao.model.Escola;
import com.app_cotacao.app_cotacao.repository.EscolaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscolaService {

    @Autowired
    private EscolaRepository escolaRepository;

    // Criar nova escola
    public Escola createEscola(Escola novaEscola) {
        return escolaRepository.save(novaEscola);
    }

    // Buscar escola por ID
    public Escola getEscolaById(Long id) {
        return escolaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Escola não encontrada com id: " + id));
    }

    // Atualizar escola
    public Escola updateEscola(Long id, Escola dadosAtualizados) {
        Escola escolaExistente = escolaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Escola não encontrada com id: " + id));

        escolaExistente.setNome(dadosAtualizados.getNome());
        escolaExistente.setEndereco(dadosAtualizados.getEndereco());

        return escolaRepository.save(escolaExistente);
    }

    // Deletar escola
    public Escola deleteEscola(Long id) {
        Escola escolaExistente = escolaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Escola não encontrada com id: " + id));

        escolaRepository.delete(escolaExistente);
        return escolaExistente;
    }
}
