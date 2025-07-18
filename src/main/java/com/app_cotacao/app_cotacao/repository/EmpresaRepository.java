package com.app_cotacao.app_cotacao.repository;

import com.app_cotacao.app_cotacao.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
