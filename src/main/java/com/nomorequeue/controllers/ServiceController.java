/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nomorequeue.controllers;

import com.nomorequeue.Respository.CompanyRepository;
import com.nomorequeue.Respository.GuichetRepository;
import com.nomorequeue.Respository.OperationRepository;
import com.nomorequeue.Respository.PrivilegeRepository;
import com.nomorequeue.Respository.RoleRepository;
import com.nomorequeue.Respository.ServiceRespository;
import com.nomorequeue.Respository.TypeReceptionRepository;
import com.nomorequeue.models.Company;
import com.nomorequeue.models.Guichet;
import com.nomorequeue.models.Operation;
import com.nomorequeue.models.Privilege;
import com.nomorequeue.models.Role;
import com.nomorequeue.models.Service;
import com.nomorequeue.models.TypeReception;
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
    PrivilegeRepository privilege_crud;
    
    @Autowired
    OperationRepository operation_crud;
    
    @Autowired
    GuichetRepository guichet_crud;
    
    @Autowired
    TypeReceptionRepository type_recep_crud;
    
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
    
    @GetMapping("get-company-service-by-ID")
    public Service getAllServiceByCompanyAndId(@RequestParam Long idcompany, @RequestParam Long idService){
        Company company = this.company_crud.findById(idcompany).get();
        return crud.findByCompanyAndId(company,idService);
    }
    
    @GetMapping("get-company-role")
    public List<Role> getAllRoleByCompany(@RequestParam Long idcompany){
        Company company = this.company_crud.findById(idcompany).get() ;
        return role_crud.findByCompany(company);
        //return crud.getReceptionByCompany(idcompany);
    }
    
    @GetMapping("get-company-role-by-ID")
    public Role getAllRoleByCompanyAndIdRole(@RequestParam Long idcompany, @RequestParam Long idRole){
        Company company = this.company_crud.findById(idcompany).get() ;
        return role_crud.findByCompanyAndId(company,idRole);
    }
    
    @GetMapping("get-company-operation")
    public List<Operation> getAllOperationByCompany(@RequestParam Long idcompany){
        Company company = this.company_crud.findById(idcompany).get() ;
        return operation_crud.findByCompany(company);
        //return crud.getReceptionByCompany(idcompany);
    }
    @GetMapping("get-company-operation-by-ID")
    public Operation getAllOperationByCompanyAndOperation(@RequestParam Long idcompany, @RequestParam Long idOperation){
        Company company = this.company_crud.findById(idcompany).get();
        return operation_crud.findByCompanyAndId(company,idOperation);
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
    
    @PostMapping("/add-guichet")
    public Guichet addGuichet(@Valid @RequestBody Guichet guichet){
        return guichet_crud.save(guichet);
    }
    
    @GetMapping("get-company-guichet")
    public List<Guichet> getAllGuichetByCompany(@RequestParam Long idcompany){
        Company company = this.company_crud.findById(idcompany).get() ;
        return guichet_crud.findByCompany(company);
        //return crud.getReceptionByCompany(idcompany);
    }
    
    @GetMapping("get-company-guichet-by-ID")
    public Guichet getAllGuichetByCompanyAndIdGuichet(@RequestParam Long idcompany, @RequestParam Long idGuichet){
        Company company = this.company_crud.findById(idcompany).get();
        return guichet_crud.findByCompanyAndId(company,idGuichet);
        //return crud.getReceptionByCompany(idcompany);
    }
    
    @GetMapping("get-all-privilege")
    public Iterable<Privilege> getAllParameterCompany(){
        return privilege_crud.findAll();
    }
    
    @PostMapping("/add-typeRecep")
    public TypeReception addTypeReception(@Valid @RequestBody TypeReception typeRecep){
        return type_recep_crud.save(typeRecep);
    }
    
    @GetMapping("get-all-typeRecep-by-company")
    public Iterable<TypeReception> getAllTypeReceptionCompany(@RequestParam Long idcompany){
        Company company = this.company_crud.findById(idcompany).get();
        return type_recep_crud.findByCompany(company);
    }
    
}
