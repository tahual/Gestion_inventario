/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.service.interfaces;

import com.inventario.gestorinventario.entity.Proveedor;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author danyt
 */
public interface ProveedorService {
    List<Proveedor> findAll();
    Optional<Proveedor> findById(Integer id);
    Proveedor save(Proveedor proveedor);
    void deleteById(Integer id);
}

