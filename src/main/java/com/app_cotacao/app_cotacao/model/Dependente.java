package com.app_cotacao.app_cotacao.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Dependente")
public class Dependente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming id_dependente is auto-generated
    @Column(name = "id_dependente")
    private Long id_dependente;

    @Column(name = "nome", nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Dependente() {}

    public Dependente(String nome, Cliente cliente) {
        this.nome = nome;
        this.cliente = cliente;
    }

    public Long getId_dependente() {
        return id_dependente;
    }

    public void setId_dependente(Long id_dependente) {
        this.id_dependente = id_dependente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
