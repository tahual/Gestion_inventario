/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.service.interfaces;

import com.inventario.gestorinventario.entity.Factura;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author danyt
 */
public interface FacturaService {
    List<Factura> findAll();
    Optional<Factura> findById(Integer id);
    Factura save(Factura factura);
    void deleteById(Integer id);
}