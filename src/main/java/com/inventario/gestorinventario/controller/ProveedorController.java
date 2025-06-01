/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.controller;

import com.inventario.gestorinventario.entity.Proveedor;
import com.inventario.gestorinventario.service.interfaces.ProveedorService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author danyt
 */
@RestController
@RequestMapping("/api/proveedores")
@CrossOrigin(origins = "*")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public ResponseEntity<List<Proveedor>> getAllProveedores() {
        return ResponseEntity.ok(proveedorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> getProveedorById(@PathVariable Integer id) {
        return proveedorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Proveedor> createProveedor(@RequestBody Proveedor proveedor) {
        return ResponseEntity.ok(proveedorService.save(proveedor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> updateProveedor(@PathVariable Integer id, @RequestBody Proveedor proveedor) {
        if (!proveedorService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        proveedor.setIdProveedor(id);
        return ResponseEntity.ok(proveedorService.save(proveedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Integer id) {
        proveedorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}