package com.app_cotacao.app_cotacao.repository;

import com.app_cotacao.app_cotacao.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}
