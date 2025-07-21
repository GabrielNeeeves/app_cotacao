package com.app_cotacao.app_cotacao.repository;

import com.app_cotacao.app_cotacao.model.Material_Empresa;
import com.app_cotacao.app_cotacao.model.fk_composta.MaterialEmpresaId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Material_EmpresaRepository extends JpaRepository<Material_Empresa, MaterialEmpresaId> {

}
