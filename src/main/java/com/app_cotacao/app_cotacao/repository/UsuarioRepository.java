package com.app_cotacao.app_cotacao.repository;

import com.app_cotacao.app_cotacao.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
