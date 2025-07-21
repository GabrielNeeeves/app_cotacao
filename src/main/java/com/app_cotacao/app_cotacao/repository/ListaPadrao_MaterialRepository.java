package com.app_cotacao.app_cotacao.repository;

import com.app_cotacao.app_cotacao.model.ListaPadrao_Material;
import com.app_cotacao.app_cotacao.model.fk_composta.ListaPadraoMaterialId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListaPadrao_MaterialRepository extends JpaRepository<ListaPadrao_Material, ListaPadraoMaterialId> {

}
