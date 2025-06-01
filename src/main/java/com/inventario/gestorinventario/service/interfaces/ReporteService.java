/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.service.interfaces;

import com.inventario.gestorinventario.entity.Reporte;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author danyt
 */
public interface ReporteService {
    List<Reporte> findAll();
    Optional<Reporte> findById(Integer id);
    Reporte save(Reporte reporte);
    void deleteById(Integer id);
}