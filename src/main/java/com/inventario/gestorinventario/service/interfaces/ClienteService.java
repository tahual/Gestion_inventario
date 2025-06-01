/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.service.interfaces;

import com.inventario.gestorinventario.entity.Cliente;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author danyt
 */
public interface ClienteService {
    List<Cliente> findAll();
    Optional<Cliente> findById(Integer id);
    Cliente save(Cliente cliente);
    void deleteById(Integer id);
}
