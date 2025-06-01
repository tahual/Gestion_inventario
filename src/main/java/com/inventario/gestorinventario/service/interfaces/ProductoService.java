/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.service.interfaces;

import com.inventario.gestorinventario.entity.Producto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author danyt
 */
public interface ProductoService {
    List<Producto> findAll();
    Optional<Producto> findById(Integer id);
    Producto save(Producto producto);
    void deleteById(Integer id);
}
