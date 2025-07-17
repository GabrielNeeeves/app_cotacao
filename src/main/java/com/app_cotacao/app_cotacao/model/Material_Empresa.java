package com.app_cotacao.app_cotacao.model;

import com.app_cotacao.app_cotacao.model.fk_composta.MaterialEmpresaId;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Material_Empresa")
public class Material_Empresa {

    @EmbeddedId // Indica que a chave primária é uma classe incorporada
    private MaterialEmpresaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_empresa")
    @JoinColumn(name = "id_empresa", insertable = false, updatable = false) // Coluna FK na tabela Material_Empresa
    private Empresa empresa; // O objeto Empresa associado

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_material")
    @JoinColumn(name = "id_material", insertable = false, updatable = false) // Coluna FK na tabela Material_Empresa
    private Material material; // O objeto Material associado

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "preco", precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "desconto", precision = 5, scale = 2)
    private BigDecimal desconto;

    @Column(name = "observacoes", length = 100)
    private String observacoes;

    public Material_Empresa() {
        this.id = new MaterialEmpresaId(); // Inicializa a chave composta
    }

    public Material_Empresa(Empresa empresa, Material material, String modelo, BigDecimal preco, BigDecimal desconto, String observacoes) {
        this.empresa = empresa;
        this.material = material;
        this.id = new MaterialEmpresaId(empresa.getId_empresa(), material.getId_material()); // Define a chave composta
        this.modelo = modelo;
        this.preco = preco;
        this.desconto = desconto;
        this.observacoes = observacoes;
    }

    public MaterialEmpresaId getId() {
        return id;
    }

    public void setId(MaterialEmpresaId id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
        // Atualiza o ID da chave composta quando a empresa é definida
        if (this.id == null) {
            this.id = new MaterialEmpresaId();
        }
        this.id.setId_empresa(empresa.getId_empresa());
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
        // Atualiza o ID da chave composta quando o material é definido
        if (this.id == null) {
            this.id = new MaterialEmpresaId();
        }
        this.id.setIdMaterial(material.getId_material());
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "MaterialEmpresa{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", preco=" + preco +
                ", desconto=" + desconto +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}