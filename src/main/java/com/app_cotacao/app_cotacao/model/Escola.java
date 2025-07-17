package com.app_cotacao.app_cotacao.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Escola")
public class Escola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_escola")
    private Long id_escola;
    @Column(name = "nome")
    private String nome;
    @Column(name = "endereco")
    private String endereco;

    public Escola() {}

    public Escola(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public Long getId_escola() {
        return id_escola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
