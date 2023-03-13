/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nomorequeue.controllers;

import com.nomorequeue.Respository.AgentRepository;
import com.nomorequeue.Respository.CompanyRepository;
import com.nomorequeue.Respository.ServiceRespository;
import com.nomorequeue.Respository.UserRepository;
import com.nomorequeue.models.Agent;
import com.nomorequeue.models.Company;
import com.nomorequeue.models.Departement;
import com.nomorequeue.models.Service;
import com.nomorequeue.models.User;
import jakarta.validation.Valid;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
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
@RequestMapping("/trait_service/agent")
public class AgentController {
    
    @Autowired
    ServiceRespository service_crud;
    
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
    
    @GetMapping("get-company-agent-by-ID")
    public Agent getAllAgentByCompany(@RequestParam Long idcompany, @RequestParam Long idAgent){
        Company company = this.company_crud.findById(idcompany).get();
        return crud.findByCompanyAndId(company,idAgent);
    }
    
    @GetMapping("get-company-service-agent")
    public List<Agent> getAllAgentByCompanyService(@RequestParam Long idcompany,@RequestParam Long idservice){
        Company company = this.company_crud.findById(idcompany).get() ;
        Service service = this.service_crud.findById(idservice).get();
        
        //return crud.findByCompany(company);
        return crud.findByCompanyAndService(company,service);
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
        
        String generatedString = RandomStringUtils.randomAlphanumeric(7); // generate password 
        user.setPassword(generatedString);
        this.user_crud.save(user);
        return agent;
    }
}
