/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.service.impl;

import com.inventario.gestorinventario.entity.Pedido;
import com.inventario.gestorinventario.repository.PedidoRepository;
import com.inventario.gestorinventario.service.interfaces.PedidoService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author danyt
 */
@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> findById(Integer id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void deleteById(Integer id) {
        pedidoRepository.deleteById(id);
    }
}
