/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.gestorinventario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author danyt
 */
@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 50)
    private String rol;
    
    @Column(nullable = false, length = 255)
    private String password; 

    // Relaciones
    @OneToMany(mappedBy = "usuario")
    private List<Producto> productos;

    @OneToMany(mappedBy = "usuario")
    private List<Proveedor> proveedores;

    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "usuario")
    private List<Reporte> reportes;

    @OneToMany(mappedBy = "usuario")
    private List<OrdenCompra> ordenesCompra;

    @OneToMany(mappedBy = "usuario")
    private List<Venta> ventas;

    // Getters y Setters

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getPassword(){
        return password; 
    }
    
    public void setPassword(String password){
        this.password = password; 
    }
}