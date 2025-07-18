package com.app_cotacao.app_cotacao.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming id_funcionario is auto-generated
    @Column(name = "id_funcionario")
    private Long idFuncionario;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "id_escola")
    private Escola escola;

    public Funcionario() {}

    public Funcionario(Usuario usuario, Empresa empresa, Escola escola) {
        this.usuario = usuario;
        this.empresa = empresa;
        this.escola = escola;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }
}
