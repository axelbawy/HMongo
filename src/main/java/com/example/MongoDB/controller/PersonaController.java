/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.MongoDB.controller;

import com.example.MongoDB.model.Persona;
import com.example.MongoDB.service.PersonaServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
 * @author ASUS
 */
@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    PersonaServiceImpl personaServiceImpl;

    @GetMapping("/read")
    public ResponseEntity<List<Persona>> read() {
        return new ResponseEntity<>(personaServiceImpl.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Persona> save(@RequestBody Persona persona) {
        return new ResponseEntity<>(personaServiceImpl.save(persona), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personaServiceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Persona> update(@PathVariable Long id, @RequestBody Persona persona) {
        Persona personaActual = personaServiceImpl.findById(id);
        if (personaActual != null) {
            personaActual.setNombre(persona.getNombre());
            personaActual.setApellido(persona.getApellido());
            personaActual.setDireccion(persona.getDireccion());
            return new ResponseEntity<>(personaServiceImpl.save(persona), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Persona> search(@PathVariable Long id) {
        return new ResponseEntity<>(personaServiceImpl.findById(id), HttpStatus.OK);
    }
}
