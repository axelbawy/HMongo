/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.MongoDB.service;

import com.example.MongoDB.model.Roles;
import com.example.MongoDB.repositiry.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class RolesServiceImpl extends GenericServiceImpl<Roles, Long> implements RolesService {

    @Autowired
    RolesRepository rolesRepository;

    @Override
    public CrudRepository<Roles, Long> getDao() {
        return rolesRepository;
    }

}
