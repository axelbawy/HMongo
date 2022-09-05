/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.MongoDB.repositiry;

import com.example.MongoDB.model.Roles;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author ASUS
 */
public interface RolesRepository extends MongoRepository<Roles, Long>{
    
}
