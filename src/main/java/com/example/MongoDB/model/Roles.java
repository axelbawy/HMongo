/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.MongoDB.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 *
 * @author ASUS
 */
@Getter
@Setter
public class Roles {
    @Id
    private Long id;
    private String nombre;
    private String descripcion;
    private String estado;

    public Roles() {
    }

    public Roles(Long id, String nombre, String descripcion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    
    
}
