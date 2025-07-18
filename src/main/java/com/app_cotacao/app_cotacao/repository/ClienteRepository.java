package com.app_cotacao.app_cotacao.repository;

import com.app_cotacao.app_cotacao.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
