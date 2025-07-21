package com.app_cotacao.app_cotacao.repository;

import com.app_cotacao.app_cotacao.model.Escola;
import com.app_cotacao.app_cotacao.model.ListaPadrao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListaPadraoRepository extends JpaRepository<ListaPadrao, Long> {

    List<ListaPadrao> findByAno(Long ano);
    List<ListaPadrao> findBySerie(String serie);
    List<ListaPadrao> findByEscola(Escola escola);
}
