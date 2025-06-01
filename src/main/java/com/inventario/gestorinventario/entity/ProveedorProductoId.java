/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author danyt
 */
@Embeddable
public class ProveedorProductoId implements Serializable {

    private Integer idProveedor;
    private Integer idProducto;

    // Constructores
    public ProveedorProductoId() {}

    public ProveedorProductoId(Integer idProveedor, Integer idProducto) {
        this.idProveedor = idProveedor;
        this.idProducto = idProducto;
    }

    // Getters y Setters
    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    // equals y hashCode obligatorios
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProveedorProductoId)) return false;
        ProveedorProductoId that = (ProveedorProductoId) o;
        return Objects.equals(idProveedor, that.idProveedor) &&
               Objects.equals(idProducto, that.idProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProveedor, idProducto);
    }
}
