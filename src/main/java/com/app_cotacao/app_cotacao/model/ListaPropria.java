package com.app_cotacao.app_cotacao.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ListaPropria")
public class ListaPropria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista_propria")
    private Long id_lista_propria;

    @Column(name = "nome")
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY) // Muitas ListaPropria podem pertencer a um Cliente
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    public ListaPropria() {}

    public ListaPropria(String nome, Cliente cliente) {
        this.nome = nome;
        this.cliente = cliente;
    }

    public Long getId_lista_propria() {
        return id_lista_propria;
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
