/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.controller;

import com.inventario.gestorinventario.entity.ProveedorProducto;
import com.inventario.gestorinventario.service.interfaces.ProveedorProductoService;
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
@RequestMapping("/api/proveedor-producto")
@CrossOrigin(origins = "*")
public class ProveedorProductoController {

    private final ProveedorProductoService service;

    public ProveedorProductoController(ProveedorProductoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProveedorProducto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{idProveedor}/{idProducto}")
    public ResponseEntity<ProveedorProducto> getById(@PathVariable Integer idProveedor, @PathVariable Integer idProducto) {
        return service.findByIdProveedorAndIdProducto(idProveedor, idProducto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProveedorProducto> create(@RequestBody ProveedorProducto proveedorProducto) {
        return ResponseEntity.ok(service.save(proveedorProducto));
    }

    @PutMapping
    public ResponseEntity<ProveedorProducto> update(@RequestBody ProveedorProducto proveedorProducto) {
        return ResponseEntity.ok(service.save(proveedorProducto));
    }

    @DeleteMapping("/{idProveedor}/{idProducto}")
    public ResponseEntity<Void> delete(@PathVariable Integer idProveedor, @PathVariable Integer idProducto) {
        service.deleteByIdProveedorAndIdProducto(idProveedor, idProducto);
        return ResponseEntity.noContent().build();
    }
}
