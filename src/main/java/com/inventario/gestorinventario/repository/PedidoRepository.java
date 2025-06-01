/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.repository;

import com.inventario.gestorinventario.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author danyt
 */
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}