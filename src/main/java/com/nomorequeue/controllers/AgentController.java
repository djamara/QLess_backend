/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nomorequeue.controllers;

import com.nomorequeue.Respository.AgentRepository;
import com.nomorequeue.Respository.CompanyRepository;
import com.nomorequeue.Respository.UserRepository;
import com.nomorequeue.models.Agent;
import com.nomorequeue.models.Company;
import com.nomorequeue.models.Departement;
import com.nomorequeue.models.User;
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
@RequestMapping("/trait_service/agent")
public class AgentController {
    
    @Autowired
    AgentRepository crud;
    
    @Autowired
    CompanyRepository company_crud;
    
    @Autowired
    UserRepository user_crud;
    
    @GetMapping("get-company-agent")
    public List<Agent> getAllAgentByCompany(@RequestParam Long idcompany){
        Company company = this.company_crud.findById(idcompany).get() ;
        return crud.findByCompany(company);
    }
    
    @GetMapping("get-all-agent")
    public Iterable<Agent> getAllAgent(){
        return crud.findAll();
    }
    
    @PostMapping("add-agent")
    public Agent addAgent(@Valid @RequestBody Agent agent){
        agent = crud.save(agent);
        User user = new User();
        user.setLogin(agent.getEmail());
        user.setAgent(agent);
        user.setCompany(agent.getCompany());
        this.user_crud.save(user);
        return agent;
    }
}
