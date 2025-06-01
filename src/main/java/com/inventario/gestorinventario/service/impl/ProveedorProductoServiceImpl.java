/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.service.impl;

import com.inventario.gestorinventario.entity.ProveedorProducto;
import com.inventario.gestorinventario.entity.ProveedorProductoId;
import com.inventario.gestorinventario.repository.ProveedorProductoRepository;
import com.inventario.gestorinventario.service.interfaces.ProveedorProductoService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author danyt
 */
@Service
public class ProveedorProductoServiceImpl implements ProveedorProductoService {

    private final ProveedorProductoRepository repository;

    public ProveedorProductoServiceImpl(ProveedorProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProveedorProducto> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ProveedorProducto> findByIdProveedorAndIdProducto(Integer idProveedor, Integer idProducto) {
        return repository.findById(new ProveedorProductoId(idProveedor, idProducto));
    }

    @Override
    public ProveedorProducto save(ProveedorProducto proveedorProducto) {
        return repository.save(proveedorProducto);
    }

    @Override
    public void deleteByIdProveedorAndIdProducto(Integer idProveedor, Integer idProducto) {
        repository.deleteById(new ProveedorProductoId(idProveedor, idProducto));
    }
}