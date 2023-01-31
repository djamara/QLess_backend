/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nomorequeue.controllers;

import com.nomorequeue.Respository.CompanyRepository;
import com.nomorequeue.Respository.IndustryRepository;
import com.nomorequeue.Respository.QualityGuessRepository;
import com.nomorequeue.Respository.RegistrationTypeRepository;
import com.nomorequeue.models.Company;
import com.nomorequeue.models.Industry;
import com.nomorequeue.models.QualityGuess;
import com.nomorequeue.models.RegistrationType;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/env")
public class IndustryController {
    
    @Autowired
    IndustryRepository industry_crud;
    
    @Autowired
    QualityGuessRepository quality_crud;
    
    @Autowired
    RegistrationTypeRepository registrationtype_crud;
    
    @Autowired
    CompanyRepository company_crud;
    
    @PostMapping("add-industry")
    public Industry addIndustry(@Valid @RequestBody Industry industry){
        return this.industry_crud.save(industry);
    }
    
    @GetMapping("get-all-industry")
    public Iterable<Industry> getAllIndustry(){
        return industry_crud.findAll();
    }
    
    @PostMapping("add-registration-type")
    public RegistrationType addRegistrationType(@Valid @RequestBody RegistrationType regtype){
        return this.registrationtype_crud.save(regtype);
    }
    
    @GetMapping("get-all-company")
    public Iterable<Company> getAllCompany(){
        return company_crud.findAll();
    }
    
    @PostMapping("add-company")
    public Company addRegistrationType(@Valid @RequestBody Company company){
        return this.company_crud.save(company);
    }
    
    @GetMapping("get-all-registration-type")
    public Iterable<RegistrationType> getAllRegistrationType(){
        return registrationtype_crud.findAll();
    }
    
    @PostMapping("add-quality-guess")
    public QualityGuess addQualityGuess(@Valid @RequestBody QualityGuess qualityguess){
        return this.quality_crud.save(qualityguess);
    }
    
    @GetMapping("get-all-quality-guess")
    public Iterable<QualityGuess> getAllQualityGuess(){
        return quality_crud.findAll();
    }
}
