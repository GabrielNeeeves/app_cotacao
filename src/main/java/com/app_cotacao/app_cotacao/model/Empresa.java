package com.app_cotacao.app_cotacao.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Long id_empresa;
    @Column(name = "nome")
    private String nome;

    public Empresa() {}

    public Empresa(String nome) {
        this.nome = nome;
    }

    public Long getId_empresa() {
        return id_empresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
