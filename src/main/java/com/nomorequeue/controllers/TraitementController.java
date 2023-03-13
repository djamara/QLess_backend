/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nomorequeue.controllers;

import com.nomorequeue.Respository.AgentRepository;
import com.nomorequeue.Respository.CompanyRepository;
import com.nomorequeue.Respository.ReceptionRepository;
import com.nomorequeue.Respository.TraitementRepository;
import com.nomorequeue.models.Agent;
import com.nomorequeue.models.Company;
import com.nomorequeue.models.Departement;
import com.nomorequeue.models.Reception;
import com.nomorequeue.models.Traitement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
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
@RequestMapping("/trait_service/traitement")
public class TraitementController {
    
    @Autowired
    TraitementRepository trait_crud;
    
    @Autowired
    ReceptionRepository recep_crud;
    
    @Autowired
    CompanyRepository company_crud;
    
    @Autowired
    AgentRepository agent_crud;
    
    @PostMapping("update-traitement")
    public Traitement updatetraitement(@RequestBody Traitement traitement){
        
       Calendar cal = Calendar.getInstance();
       
       Date date = new Date();
       Timestamp time = new Timestamp(System.currentTimeMillis());
       
       java.sql.Date datesql = new java.sql.Date(date.getTime());
       
       traitement.setTicket_date_update(datesql);
       traitement.setTicket_heure_update(time);
       
       Reception recep = traitement.getReception();
       this.recep_crud.save(recep);
       
       return trait_crud.save(traitement);
    }
    
    @GetMapping("get-company-traitement-by-agent-status")
    public List<Traitement> getAllDepartByCompany(@RequestParam Long idcompany,@RequestParam String status,@RequestParam Long idagent){
        Company company = this.company_crud.findById(idcompany).get() ;
        Agent agent = this.agent_crud.findById(idagent).get();
        //return trait_crud.findByCompany(company);
        return trait_crud.findByCompanyAndStatusAndAgent(company,status,agent);
    }
    
    @GetMapping("get-company-traitement-termAndTransf")
    public List<Traitement> getAllTermAndTransf(@RequestParam Long idcompany,@RequestParam Long idagent){
        //Company company = this.company_crud.findById(idcompany).get() ;
        //return trait_crud.findByCompany(company);
        return trait_crud.getAllTerminAndTransf(idcompany,idagent);
    }
    
    @GetMapping("get-company-traitement-termine")
    public List<Traitement> getAllTraitTermine(){
        return trait_crud.getAllTraitTermine();
    }
}
