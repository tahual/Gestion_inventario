/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.service.impl;

import com.inventario.gestorinventario.entity.Proveedor;
import com.inventario.gestorinventario.repository.ProveedorRepository;
import com.inventario.gestorinventario.service.interfaces.ProveedorService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author danyt
 */
@Service
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorServiceImpl(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }

    @Override
    public Optional<Proveedor> findById(Integer id) {
        return proveedorRepository.findById(id);
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public void deleteById(Integer id) {
        proveedorRepository.deleteById(id);
    }
}