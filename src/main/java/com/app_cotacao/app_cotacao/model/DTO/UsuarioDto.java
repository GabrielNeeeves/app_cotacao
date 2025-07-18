package com.app_cotacao.app_cotacao.model.DTO;

import com.app_cotacao.app_cotacao.model.roles.Roles;

public record UsuarioDto(String nome, String email, String senha, Roles role) {
}
