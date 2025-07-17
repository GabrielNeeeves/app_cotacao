package com.app_cotacao.app_cotacao.model.fk_composta;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class MaterialEmpresaId implements Serializable {

    @Column(name = "id_empresa")
    private Long id_empresa;

    @Column(name = "id_material")
    private Long id_material;

    public MaterialEmpresaId() {
    }

    public MaterialEmpresaId(Long idEmpresa, Long idMaterial) {
        this.id_empresa = idEmpresa;
        this.id_material = idMaterial;
    }

    public Long getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Long id_empresa) {
        this.id_empresa = id_empresa;
    }

    public Long getIdMaterial() {
        return id_material;
    }

    public void setIdMaterial(Long idMaterial) {
        this.id_material = idMaterial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialEmpresaId that = (MaterialEmpresaId) o;
        return id_empresa.equals(that.id_empresa) &&
                id_material.equals(that.id_material);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id_empresa, id_material);
    }
}
