/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.service.interfaces;

import com.inventario.gestorinventario.entity.Venta;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author danyt
 */
public interface VentaService {
    List<Venta> findAll();
    Optional<Venta> findById(Integer id);
    Venta save(Venta venta);
    void deleteById(Integer id);
}