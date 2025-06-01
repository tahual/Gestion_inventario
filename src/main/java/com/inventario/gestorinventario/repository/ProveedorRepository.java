/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.repository;

import com.inventario.gestorinventario.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author danyt
 */
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
}