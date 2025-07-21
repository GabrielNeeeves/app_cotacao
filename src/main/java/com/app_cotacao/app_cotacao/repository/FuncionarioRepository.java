package com.app_cotacao.app_cotacao.repository;

import com.app_cotacao.app_cotacao.model.Empresa;
import com.app_cotacao.app_cotacao.model.Escola;
import com.app_cotacao.app_cotacao.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {


    // To find employees by company:
    List<Funcionario> findByEmpresa(Empresa empresa);

    // To find employees by school (can be null):
    List<Funcionario> findByEscola(Escola escola);

}
