/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.service.interfaces;

import com.inventario.gestorinventario.entity.Pedido;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author danyt
 */
public interface PedidoService {
    List<Pedido> findAll();
    Optional<Pedido> findById(Integer id);
    Pedido save(Pedido pedido);
    void deleteById(Integer id);
}
