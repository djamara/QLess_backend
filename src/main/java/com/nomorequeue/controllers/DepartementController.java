/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nomorequeue.controllers;

import com.nomorequeue.Respository.CompanyRepository;
import com.nomorequeue.Respository.DepartementRepository;
import com.nomorequeue.models.Company;
import com.nomorequeue.models.Departement;
import com.nomorequeue.models.Service;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CYRILLE DJAMARA
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/trait_service/departement")
public class DepartementController {
    
    @Autowired
    DepartementRepository crud;
    
    @Autowired
    CompanyRepository company_crud;
     
    
    @GetMapping("/get-all-depart")
    public Iterable<Departement> getAllDepartement(){
        return crud.findAll();
    }
    
    @GetMapping("get-company-depart")
    public List<Departement> getAllDepartByCompany(@RequestParam Long idcompany){
        Company company = this.company_crud.findById(idcompany).get() ;
        return crud.findByCompany(company);
    }
    
    @PostMapping("/add-depart")
    public Departement addDepartement(@Valid @RequestBody Departement departement){
        
        Departement depart = crud.save(departement);
        return depart;
    }
}
