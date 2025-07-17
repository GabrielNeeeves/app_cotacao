package com.app_cotacao.app_cotacao.model.fk_composta;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable // Indica que esta classe pode ser incorporada como parte de uma chave primária
public class ListaPropriaMaterialId implements Serializable {

    @Column(name = "id_lista_propria")
    private Long id_lista_propria;

    @Column(name = "id_material")
    private Long id_material;

    // Construtores
    public ListaPropriaMaterialId() {
    }

    public ListaPropriaMaterialId(Long idListaPropria, Long idMaterial) {
        this.id_lista_propria = idListaPropria;
        this.id_material = idMaterial;
    }

    // Getters and Setters
    public Long getIdListaPropria() {
        return id_lista_propria;
    }

    public void setIdListaPropria(Long idListaPropria) {
        this.id_lista_propria = idListaPropria;
    }

    public Long getId_material() {
        return id_material;
    }

    public void setId_material(Long id_material) {
        this.id_material = id_material;
    }

    // É CRUCIAL sobrescrever equals() e hashCode() para chaves primárias compostas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaPropriaMaterialId that = (ListaPropriaMaterialId) o;
        return Objects.equals(id_lista_propria, that.id_lista_propria) &&
                Objects.equals(id_material, that.id_material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_lista_propria, id_material);
    }
}