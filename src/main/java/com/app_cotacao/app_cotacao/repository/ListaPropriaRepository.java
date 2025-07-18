package com.app_cotacao.app_cotacao.repository;

import com.app_cotacao.app_cotacao.model.ListaPropria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListaPropriaRepository extends JpaRepository<ListaPropria, Long> {

    List<ListaPropria> findByClienteId(Long id_cliente);

}
