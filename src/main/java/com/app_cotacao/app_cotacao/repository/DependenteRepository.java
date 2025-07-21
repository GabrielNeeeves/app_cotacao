package com.app_cotacao.app_cotacao.repository;

import com.app_cotacao.app_cotacao.model.Cliente;
import com.app_cotacao.app_cotacao.model.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DependenteRepository extends JpaRepository<Dependente, Long> {

    //encontrar dependentes por cliente:
    List<Dependente> findByCliente(Cliente cliente);
    //List<Dependente> findByClienteId_cliente(Long id_cliente);

}
