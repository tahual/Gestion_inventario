/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.service.interfaces;

import com.inventario.gestorinventario.entity.ProveedorProducto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author danyt
 */
public interface ProveedorProductoService {
    List<ProveedorProducto> findAll();
    Optional<ProveedorProducto> findByIdProveedorAndIdProducto(Integer idProveedor, Integer idProducto);
    ProveedorProducto save(ProveedorProducto proveedorProducto);
    void deleteByIdProveedorAndIdProducto(Integer idProveedor, Integer idProducto);
}
