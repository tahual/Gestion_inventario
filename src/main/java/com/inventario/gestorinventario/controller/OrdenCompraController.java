/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.controller;

import com.inventario.gestorinventario.entity.OrdenCompra;
import com.inventario.gestorinventario.service.interfaces.OrdenCompraService;
import java.util.List;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/ordenes-compra")
public class OrdenCompraController {

    private final OrdenCompraService ordenCompraService;

    public OrdenCompraController(OrdenCompraService ordenCompraService) {
        this.ordenCompraService = ordenCompraService;
    }

    @GetMapping
    public List<OrdenCompra> getAll() {
        return ordenCompraService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenCompra> getById(@PathVariable Integer id) {
        return ordenCompraService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrdenCompra create(@RequestBody OrdenCompra ordenCompra) {
        return ordenCompraService.save(ordenCompra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenCompra> update(@PathVariable Integer id, @RequestBody OrdenCompra ordenCompra) {
        return ordenCompraService.findById(id)
                .map(existing -> {
                    ordenCompra.setIdOrdenCompra(id);
                    return ResponseEntity.ok(ordenCompraService.save(ordenCompra));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (ordenCompraService.findById(id).isPresent()) {
            ordenCompraService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
