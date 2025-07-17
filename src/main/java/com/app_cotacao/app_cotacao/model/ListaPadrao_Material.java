package com.app_cotacao.app_cotacao.model;

import com.app_cotacao.app_cotacao.model.fk_composta.ListaPadraoMaterialId;
import jakarta.persistence.*;

@Entity
@Table(name = "ListaPadrao_Material")
public class ListaPadrao_Material {

    @EmbeddedId
    private ListaPadraoMaterialId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_lista")
    @JoinColumn(name = "id_lista", insertable = false, updatable = false)
    private ListaPadrao listaPadrao;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_material")
    @JoinColumn(name = "id_material", insertable = false, updatable = false)
    private Material material;

    public ListaPadrao_Material() {
        this.id = new ListaPadraoMaterialId(); // Inicializa a chave composta
    }

    public ListaPadrao_Material(ListaPadrao listaPadrao, Material material) {
        this.listaPadrao = listaPadrao;
        this.material = material;
        this.id = new ListaPadraoMaterialId(listaPadrao.getId_lista(), material.getId_material());
    }

    public ListaPadraoMaterialId getId() {
        return id;
    }

    public void setId(ListaPadraoMaterialId id) {
        this.id = id;
    }

    public ListaPadrao getListaPadrao() {
        return listaPadrao;
    }

    public void setListaPadrao(ListaPadrao listaPadrao) {
        this.listaPadrao = listaPadrao;
        if (this.id == null) {
            this.id = new ListaPadraoMaterialId();
        }
        this.id.setIdLista(listaPadrao.getId_lista());
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
        if (this.id == null) {
            this.id = new ListaPadraoMaterialId();
        }
        this.id.setIdMaterial(material.getId_material());
    }

    @Override
    public String toString() {
        return "ListaPadraoMaterial{" +
                "id=" + id +
                ", listaPadraoId=" + (listaPadrao != null ? listaPadrao.getId_lista() : "null") +
                ", materialId=" + (material != null ? material.getId_material() : "null") +
                '}';
    }
}