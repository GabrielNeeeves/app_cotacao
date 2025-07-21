package com.app_cotacao.app_cotacao.repository;

import com.app_cotacao.app_cotacao.model.MateriaisEscolhidos;
import com.app_cotacao.app_cotacao.model.fk_composta.MateriaisEscolhidosId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MateriaisEscolhidosRepository extends JpaRepository<MateriaisEscolhidos, MateriaisEscolhidosId> {

}

