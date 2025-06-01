/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.controller;

import com.inventario.gestorinventario.entity.Factura;
import com.inventario.gestorinventario.service.interfaces.FacturaService;
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
@RequestMapping("/api/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public List<Factura> getAllFacturas() {
        return facturaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> getFacturaById(@PathVariable Integer id) {
        return facturaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Factura createFactura(@RequestBody Factura factura) {
        return facturaService.save(factura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura> updateFactura(@PathVariable Integer id, @RequestBody Factura facturaDetails) {
        return facturaService.findById(id).map(factura -> {
            factura.setNumeroFactura(facturaDetails.getNumeroFactura());
            factura.setFechaEmision(facturaDetails.getFechaEmision());
            factura.setMontoTotal(facturaDetails.getMontoTotal());
            factura.setVenta(facturaDetails.getVenta());
            factura.setProducto(facturaDetails.getProducto());
            Factura updated = facturaService.save(factura);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFactura(@PathVariable Integer id) {
        if (facturaService.findById(id).isPresent()) {
            facturaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
