package com.app_cotacao.app_cotacao.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material")
    private Long id_material;

    @Column(name = "nome")
    private String nome;

    public Material(){}

    public Material(String nome) {
        this.nome = nome;
    }

    public Long getId_material() {
        return id_material;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
