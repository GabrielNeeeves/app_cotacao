package com.app_cotacao.app_cotacao.repository;

import com.app_cotacao.app_cotacao.model.ListaPropia_Material;
import com.app_cotacao.app_cotacao.model.fk_composta.ListaPropriaMaterialId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListaPropia_MaterialRepository extends JpaRepository<ListaPropia_Material, ListaPropriaMaterialId> {


}
