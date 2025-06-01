/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.controller;

import com.inventario.gestorinventario.entity.Reporte;
import com.inventario.gestorinventario.service.interfaces.ReporteService;
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
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping
    public List<Reporte> getAll() {
        return reporteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reporte> getById(@PathVariable Integer id) {
        return reporteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reporte create(@RequestBody Reporte reporte) {
        return reporteService.save(reporte);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reporte> update(@PathVariable Integer id, @RequestBody Reporte reporte) {
        return reporteService.findById(id)
                .map(existing -> {
                    reporte.setIdReporte(id);
                    return ResponseEntity.ok(reporteService.save(reporte));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (reporteService.findById(id).isPresent()) {
            reporteService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}