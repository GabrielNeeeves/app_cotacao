package com.app_cotacao.app_cotacao.model.fk_composta;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MateriaisEscolhidosId implements Serializable {

    @Column(name = "id_cliente")
    private Long id_cliente;

    @Column(name = "id_material")
    private Long id_material;

    // Construtores
    public MateriaisEscolhidosId() {
    }

    public MateriaisEscolhidosId(Long idCliente, Long idMaterial) {
        this.id_cliente = idCliente;
        this.id_material = idMaterial;
    }

    // Getters and Setters
    public Long getIdCliente() {
        return id_cliente;
    }

    public void setIdCliente(Long idCliente) {
        this.id_cliente = idCliente;
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
        MateriaisEscolhidosId that = (MateriaisEscolhidosId) o;
        return Objects.equals(id_cliente, that.id_cliente) &&
                Objects.equals(id_material, that.id_material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_cliente, id_material);
    }
}
