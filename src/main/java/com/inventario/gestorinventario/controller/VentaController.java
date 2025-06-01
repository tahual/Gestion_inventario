/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.controller;

import com.inventario.gestorinventario.entity.Venta;
import com.inventario.gestorinventario.service.interfaces.VentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping
    public List<Venta> getAllVentas() {
        return ventaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable Integer id) {
        return ventaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Venta createVenta(@RequestBody Venta venta) {
        return ventaService.save(venta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable Integer id, @RequestBody Venta ventaDetails) {
        return ventaService.findById(id).map(venta -> {
            venta.setFechaVenta(ventaDetails.getFechaVenta());
            venta.setTotal(ventaDetails.getTotal());
            venta.setCliente(ventaDetails.getCliente());
            venta.setUsuario(ventaDetails.getUsuario());
            Venta updatedVenta = ventaService.save(venta);
            return ResponseEntity.ok(updatedVenta);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Integer id) {
        if (ventaService.findById(id).isPresent()) {
            ventaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

