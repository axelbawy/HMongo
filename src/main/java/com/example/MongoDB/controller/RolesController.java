/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.MongoDB.controller;

import com.example.MongoDB.model.Roles;
import com.example.MongoDB.service.RolesServiceImpl;
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
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    RolesServiceImpl rolesServiceImpl;

    @GetMapping("/read")
    public ResponseEntity<List<Roles>> read() {
        return new ResponseEntity<>(rolesServiceImpl.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Roles> save(@RequestBody Roles roles) {
        return new ResponseEntity<>(rolesServiceImpl.save(roles), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rolesServiceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Roles> update(@PathVariable Long id, @RequestBody Roles roles) {
        Roles personaActual = rolesServiceImpl.findById(id);
        if (personaActual != null) {
            personaActual.setNombre(roles.getNombre());
            personaActual.setEstado(roles.getEstado());
            personaActual.setDescripcion(roles.getDescripcion());
            return new ResponseEntity<>(rolesServiceImpl.save(roles), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Roles> search(@PathVariable Long id) {
        return new ResponseEntity<>(rolesServiceImpl.findById(id), HttpStatus.OK);
    }
}
