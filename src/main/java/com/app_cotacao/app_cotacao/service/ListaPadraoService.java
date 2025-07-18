package com.app_cotacao.app_cotacao.service;

import com.app_cotacao.app_cotacao.model.Escola;
import com.app_cotacao.app_cotacao.model.ListaPadrao;
import com.app_cotacao.app_cotacao.repository.EscolaRepository;
import com.app_cotacao.app_cotacao.repository.ListaPadraoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaPadraoService {

    @Autowired
    private ListaPadraoRepository listaPadraoRepository;

    @Autowired
    private EscolaRepository escolaRepository;

    // Criar lista
    public ListaPadrao createListaPadrao(ListaPadrao lista) {
        Long escolaId = lista.getEscola().getId_escola();
        Escola escola = escolaRepository.findById(escolaId)
                .orElseThrow(() -> new EntityNotFoundException("Escola não encontrada com id: " + escolaId));
        lista.setEscola(escola);
        return listaPadraoRepository.save(lista);
    }

    // Buscar por id
    public ListaPadrao getListaPadraoById(Long id) {
        return listaPadraoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ListaPadrao não encontrada com id: " + id));
    }

    // Listar todas as listas
    public List<ListaPadrao> getAllListas() {
        return listaPadraoRepository.findAll();
    }

    // Atualizar lista
    public ListaPadrao updateListaPadrao(Long id, ListaPadrao dadosAtualizados) {
        ListaPadrao existente = listaPadraoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ListaPadrao não encontrada com id: " + id));

        existente.setAno(dadosAtualizados.getAno());
        existente.setSerie(dadosAtualizados.getSerie());
        existente.setProfessor(dadosAtualizados.getProfessor());
        existente.setObservacoes(dadosAtualizados.getObservacoes());
        existente.setDescricao(dadosAtualizados.getDescricao());

        // Atualiza escola se for diferente
        if (dadosAtualizados.getEscola() != null) {
            Long novaEscolaId = dadosAtualizados.getEscola().getId_escola();
            Escola novaEscola = escolaRepository.findById(novaEscolaId)
                    .orElseThrow(() -> new EntityNotFoundException("Escola não encontrada com id: " + novaEscolaId));
            existente.setEscola(novaEscola);
        }

        return listaPadraoRepository.save(existente);
    }

    // Deletar lista
    public void deleteListaPadrao(Long id) {
        ListaPadrao existente = listaPadraoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ListaPadrao não encontrada com id: " + id));
        listaPadraoRepository.delete(existente);
    }
}
