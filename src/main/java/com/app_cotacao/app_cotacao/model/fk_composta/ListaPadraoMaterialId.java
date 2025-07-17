package com.app_cotacao.app_cotacao.model.fk_composta;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ListaPadraoMaterialId implements Serializable {

    @Column(name = "id_lista")
    private Long id_lista;

    @Column(name = "id_material")
    private Long id_material;

    public ListaPadraoMaterialId() {
    }

    public ListaPadraoMaterialId(Long idLista, Long idMaterial) {
        this.id_lista = idLista;
        this.id_material = idMaterial;
    }

    public Long getIdLista() {
        return id_lista;
    }

    public void setIdLista(Long idLista) {
        this.id_lista = idLista;
    }

    public Long getIdMaterial() {
        return id_material;
    }

    public void setIdMaterial(Long idMaterial) {
        this.id_material = idMaterial;
    }

    // É CRUCIAL sobrescrever equals() e hashCode() para chaves primárias compostas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaPadraoMaterialId that = (ListaPadraoMaterialId) o;
        return Objects.equals(id_lista, that.id_lista) &&
                Objects.equals(id_material, that.id_material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_lista, id_material);
    }
}