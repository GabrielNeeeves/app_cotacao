package com.app_cotacao.app_cotacao.model;

import com.app_cotacao.app_cotacao.model.fk_composta.MateriaisEscolhidosId;
import jakarta.persistence.*;

@Entity
@Table(name = "MateriaisEscolhidos")
public class MateriaisEscolhidos {

    @EmbeddedId
    private MateriaisEscolhidosId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_cliente")
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_material")
    @JoinColumn(name = "id_material", insertable = false, updatable = false)
    private Material material;

    public MateriaisEscolhidos() {
        this.id = new MateriaisEscolhidosId();
    }

    public MateriaisEscolhidos(Cliente cliente, Material material) {
        this.cliente = cliente;
        this.material = material;
        this.id = new MateriaisEscolhidosId(cliente.getId_cliente(), material.getId_material());
    }

    public MateriaisEscolhidosId getId() {
        return id;
    }

    public void setId(MateriaisEscolhidosId id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        if (this.id == null) {
            this.id = new MateriaisEscolhidosId();
        }
        this.id.setIdCliente(cliente.getId_cliente());
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
        if (this.id == null) {
            this.id = new MateriaisEscolhidosId();
        }
        this.id.setIdMaterial(material.getId_material());
    }

    @Override
    public String toString() {
        return "MateriaisEscolhidos{" +
                "id=" + id +
                ", clienteId=" + (cliente != null ? cliente.getId_cliente() : "null") +
                ", materialId=" + (material != null ? material.getId_material() : "null") +
                '}';
    }
}
