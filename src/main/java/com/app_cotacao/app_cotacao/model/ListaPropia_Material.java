package com.app_cotacao.app_cotacao.model;

import com.app_cotacao.app_cotacao.model.fk_composta.ListaPropriaMaterialId;
import jakarta.persistence.*;

@Entity
@Table(name = "ListaPropia_Material")
public class ListaPropia_Material {

    @EmbeddedId
    private ListaPropriaMaterialId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_lista_propria")
    @JoinColumn(name = "id_lista_propria", insertable = false, updatable = false)
    private ListaPropria listaPropria;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_material")
    @JoinColumn(name = "id_material", insertable = false, updatable = false)
    private Material material;

    public ListaPropia_Material() {
        this.id = new ListaPropriaMaterialId();
    }

    public ListaPropia_Material(ListaPropria listaPropria, Material material) {
        this.listaPropria = listaPropria;
        this.material = material;
        this.id = new ListaPropriaMaterialId(listaPropria.getId_lista_propria(), material.getId_material());
    }

    public ListaPropriaMaterialId getId() {
        return id;
    }

    public ListaPropria getListaPropria() {
        return listaPropria;
    }

    public void setListaPropria(ListaPropria listaPropria) {
        this.listaPropria = listaPropria;
        if (this.id == null) {
            this.id = new ListaPropriaMaterialId();
        }
        this.id.setIdListaPropria(listaPropria.getId_lista_propria());
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
        if (this.id == null) {
            this.id = new ListaPropriaMaterialId();
        }
        this.id.setId_material(material.getId_material());
    }

    @Override
    public String toString() {
        return "ListaPropriaMaterial{" +
                "id=" + id +
                ", listaPropriaId=" + (listaPropria != null ? listaPropria.getId_lista_propria() : "null") +
                ", materialId=" + (material != null ? material.getId_material() : "null") +
                '}';
    }

}
