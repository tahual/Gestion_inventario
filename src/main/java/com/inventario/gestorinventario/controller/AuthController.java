/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.controller;

import com.inventario.gestorinventario.LoginRequest;
import com.inventario.gestorinventario.LoginResponse;
import com.inventario.gestorinventario.entity.Usuario;
import com.inventario.gestorinventario.service.interfaces.UsuarioService;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author danyt
 */
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<Usuario> usuarioOpt = usuarioService.findByEmailAndPassword(
                loginRequest.getEmail(), loginRequest.getPassword()
        );

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            LoginResponse response = new LoginResponse();
            response.setMessage("Login exitoso");
            response.setNombre(usuario.getNombre());
            response.setRol(usuario.getRol());
            response.setToken("fake-token"); // Aquí puedes implementar JWT si quieres
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}
