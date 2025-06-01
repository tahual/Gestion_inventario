/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.service.impl;

import com.inventario.gestorinventario.entity.Usuario;
import com.inventario.gestorinventario.repository.UsuarioRepository;
import com.inventario.gestorinventario.service.interfaces.UsuarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author danyt
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Optional<Usuario> findByEmailAndPassword(String email, String password) {
        return usuarioRepository.findByEmailAndPassword(email, password);
    }
    
    
    public Usuario login(String username, String password) {
        Optional<Usuario> usuario = usuarioRepository.findByEmailAndPassword(username, password);
        return usuario.orElse(null);
    }

}
