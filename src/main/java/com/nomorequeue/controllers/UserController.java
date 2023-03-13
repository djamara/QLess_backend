/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nomorequeue.controllers;

import com.nomorequeue.Respository.AgentRepository;
import com.nomorequeue.Respository.CompanyRepository;
import com.nomorequeue.Respository.PrivilegeRepository;
import com.nomorequeue.Respository.RoleRepository;
import com.nomorequeue.Respository.UserRepository;
import com.nomorequeue.models.Agent;
import com.nomorequeue.models.Company;
import com.nomorequeue.models.Privilege;
import com.nomorequeue.models.Role;
import com.nomorequeue.models.User;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author CYRILLE DJAMARA
 */

@RestController
@RequestMapping("/trait_service/user")
public class UserController {
    
    @Autowired
    CompanyRepository company_crud;
    @Autowired
    UserRepository user_crud;
    @Autowired
    RoleRepository role_crud;
    @Autowired
    PrivilegeRepository privilege_crud;
    @Autowired
    AgentRepository agent_crud;
    @Autowired
    SessionFactory session;
    
    @PostMapping("add-privilege")
    public Privilege addPrivilege(@Valid @RequestBody Privilege privilege){
        return this.privilege_crud.save(privilege);
    }
    
    @GetMapping("get-all-privilege")
    public Iterable<Privilege> getAllPrivilege(){
        return privilege_crud.findAll();
    }
    
    @PostMapping("add-role")
    public Role addRole(@Valid @RequestBody Role role){
        return this.role_crud.save(role);
    }
    
    @GetMapping("get-company-role")
    public List<Role> getAllRoleByCompany(@RequestParam Long idcompany){
        Company company = this.company_crud.findById(idcompany).get() ;
        return role_crud.findByCompany(company);
    }
    
    @GetMapping("get-all-role")
    public Iterable<Role> getAllRole(){
        return role_crud.findAll();
    }
    
    @PostMapping("add-user")
    public User addUser(@Valid @RequestBody Agent agent){
        
        //Company company = this.company_crud.save(user.getCompany()); //creer la company
        
        //Agent agent = user.getAgent();
        //agent.setCompany(company);
        
        //if there is no role provided, we create Admin
        if(agent.getRole() == null){
            Role role = new Role();
            role.setCompany(agent.getCompany());
            role.setRole_name("Administrateur");
            role = this.role_crud.save(role); // save the role
            
            agent.setRole(role);
            
        }
        agent = this.agent_crud.save(agent); // save agent 
        
        String generatedString = RandomStringUtils.randomAlphanumeric(7); // generate password   
        
        User user = new User();
        user.setPassword(generatedString);
        user.setAgent(agent);
        user.setCompany(agent.getCompany());
        
        return this.user_crud.save(user);
    }
    
    @GetMapping("get-all-user")
    public Iterable<User> getAllUser(){
        return user_crud.findAll();
    }
    
    @PostMapping("login")
    public User login(@Valid @RequestBody User user){
       user = this.user_crud.findByLoginPassword(user.getLogin(), user.getPassword());
       if(user != null){
           String token = UUID.randomUUID().toString();
           user.setToken(token);
           user = user_crud.save(user);
           return user;
       }
       return user;
    }
    
    @PostMapping("login-token")
    public User loginWToken(@RequestBody String token){
       return this.user_crud.findByToken(token);
    }
}
