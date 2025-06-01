/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.service.impl;

import com.inventario.gestorinventario.entity.OrdenCompra;
import com.inventario.gestorinventario.repository.OrdenCompraRepository;
import com.inventario.gestorinventario.service.interfaces.OrdenCompraService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author danyt
 */
@Service
public class OrdenCompraServiceImpl implements OrdenCompraService {

    private final OrdenCompraRepository ordenCompraRepository;

    public OrdenCompraServiceImpl(OrdenCompraRepository ordenCompraRepository) {
        this.ordenCompraRepository = ordenCompraRepository;
    }

    @Override
    public List<OrdenCompra> findAll() {
        return ordenCompraRepository.findAll();
    }

    @Override
    public Optional<OrdenCompra> findById(Integer id) {
        return ordenCompraRepository.findById(id);
    }

    @Override
    public OrdenCompra save(OrdenCompra ordenCompra) {
        return ordenCompraRepository.save(ordenCompra);
    }

    @Override
    public void deleteById(Integer id) {
        ordenCompraRepository.deleteById(id);
    }
}
