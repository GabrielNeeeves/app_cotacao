package com.app_cotacao.app_cotacao.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ListaPadrao")
public class ListaPadrao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista")
    private Long id_lista;

    @Column(name = "ano")
    private Integer ano;
    @Column(name = "serie")
    private String serie;
    @Column(name = "professor")
    private String professor;
    @Column(name = "observacoes")
    private String observacoes;
    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_escola", nullable = false)
    private Escola escola;

    public ListaPadrao() {}

    public ListaPadrao(Integer ano, String serie, String professor, String observacoes, String descricao, Escola escola) {
        this.ano = ano;
        this.serie = serie;
        this.professor = professor;
        this.observacoes = observacoes;
        this.descricao = descricao;
        this.escola = escola;
    }

    public Long getId_lista() {
        return id_lista;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }
}


