/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

/**
 *
 * @author danyt
 */
@Entity
@Table(name = "ProveedorProducto")
public class ProveedorProducto {

    @EmbeddedId
    private ProveedorProductoId id;

    @ManyToOne
    @MapsId("idProveedor")
    @JoinColumn(name = "idProveedor", nullable = false)
    private Proveedor proveedor;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    // Constructor vacío
    public ProveedorProducto() {}

    // Getters y Setters
    public ProveedorProductoId getId() {
        return id;
    }

    public void setId(ProveedorProductoId id) {
        this.id = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}