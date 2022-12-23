/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nomorequeue.controllers;

import com.nomorequeue.Respository.TraitementRepository;
import com.nomorequeue.models.Traitement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CYRILLE DJAMARA
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/traitement")
public class TraitementController {
    
    @Autowired
    TraitementRepository trait_crud;
    
    @PostMapping("update-traitement")
    public Traitement updatetraitement(@RequestBody Traitement traitement){
        
       Calendar cal = Calendar.getInstance();
       
       Date date = new Date();
       Timestamp time = new Timestamp(System.currentTimeMillis());
       
       java.sql.Date datesql = new java.sql.Date(date.getTime());
       
       traitement.setTicket_date_update(datesql);
       traitement.setTicket_heure_update(time);
       
       return trait_crud.save(traitement);
    }
}
