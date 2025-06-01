/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.service.interfaces;

import com.inventario.gestorinventario.entity.Usuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author danyt
 */
public interface UsuarioService {
    List<Usuario> findAll();
    Optional<Usuario> findById(Integer id);
    Optional<Usuario> findByEmailAndPassword(String email, String password);
    Usuario save(Usuario usuario);
    void deleteById(Integer id);
}
