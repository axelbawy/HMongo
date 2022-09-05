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
public class Persona {
    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private String direccion;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }
    
    
}
