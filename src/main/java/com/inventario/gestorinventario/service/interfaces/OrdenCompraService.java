/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.service.interfaces;

import com.inventario.gestorinventario.entity.OrdenCompra;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author danyt
 */
public interface OrdenCompraService {
    List<OrdenCompra> findAll();
    Optional<OrdenCompra> findById(Integer id);
    OrdenCompra save(OrdenCompra ordenCompra);
    void deleteById(Integer id);
}
