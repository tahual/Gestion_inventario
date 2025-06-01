/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.service.impl;

import com.inventario.gestorinventario.entity.Cliente;
import com.inventario.gestorinventario.repository.ClienteRepository;
import com.inventario.gestorinventario.service.interfaces.ClienteService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author danyt
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Integer id) {
        clienteRepository.deleteById(id);
    }
}