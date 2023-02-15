/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nomorequeue.controllers;

import com.nomorequeue.Respository.CompanyRepository;
import com.nomorequeue.Respository.OperationRepository;
import com.nomorequeue.Respository.RoleRepository;
import com.nomorequeue.Respository.ServiceRespository;
import com.nomorequeue.models.Company;
import com.nomorequeue.models.Operation;
import com.nomorequeue.models.Role;
import com.nomorequeue.models.Service;
import jakarta.validation.Valid;
import java.util.List;
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
@RequestMapping("/trait_service/service")
public class ServiceController {
    
    @Autowired
    ServiceRespository crud;
    @Autowired
    CompanyRepository company_crud;
    
    @Autowired 
    RoleRepository role_crud;
    
    @Autowired
    OperationRepository operation_crud;
    
    @GetMapping("/get-all-service")
    public Iterable<Service> getAllService(){
        return crud.findAll();
    }
    
    @GetMapping("get-company-service")
    public List<Service> getAllServiceByCompany(@RequestParam Long idcompany){
        Company company = this.company_crud.findById(idcompany).get() ;
        return crud.findByCompany(company);
        //return crud.getReceptionByCompany(idcompany);
    }
    
    @GetMapping("get-company-role")
    public List<Role> getAllRoleByCompany(@RequestParam Long idcompany){
        Company company = this.company_crud.findById(idcompany).get() ;
        return role_crud.findByCompany(company);
        //return crud.getReceptionByCompany(idcompany);
    }
    
    @GetMapping("get-company-operation")
    public List<Operation> getAllOperationByCompany(@RequestParam Long idcompany){
        Company company = this.company_crud.findById(idcompany).get() ;
        return operation_crud.findByCompany(company);
        //return crud.getReceptionByCompany(idcompany);
    }
    
    @PostMapping("/add-service")
    public Service addService(@Valid @RequestBody Service service){
        return crud.save(service);
    }
    
    @PostMapping("/add-role")
    public Role addRole(@Valid @RequestBody Role role){
        return role_crud.save(role);
    }
    
    @PostMapping("/add-operation")
    public Operation addOperation(@Valid @RequestBody Operation operation){
        return operation_crud.save(operation);
    }
    
}
