/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nomorequeue.controllers;

import com.nomorequeue.Respository.CompanyRepository;
import com.nomorequeue.Respository.ReceptionRepository;
import com.nomorequeue.models.Company;
import com.nomorequeue.models.Reception;
import jakarta.validation.Valid;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/reception")
public class ReceptionController {
    
    @Autowired
    ReceptionRepository crud;
    @Autowired
    CompanyRepository company_crud;
    
    @GetMapping("get-all-reception")
    public Iterable<Reception> getAllReception(){
        return crud.findAll();
    }
    
    @GetMapping("get-company-reception")
    public List<Reception> getAllReceptionByCompany(@RequestParam Long idcompany){
        Company company = this.company_crud.findById(idcompany).get() ;
        return crud.findByCompany(company);
        //return crud.getReceptionByCompany(idcompany);
    }
        
    @PostMapping("add-reception")
    public Reception addService(@Valid @RequestBody Reception reception){
        
       Calendar cal = Calendar.getInstance();
       
       Date date = new Date();
       Timestamp time = new Timestamp(System.currentTimeMillis());
       
       java.sql.Date datesql = new java.sql.Date(date.getTime());   
       
       String ticket_numero = "t-"+cal.get(Calendar.YEAR)+"-s-0"+datesql.getTime();
       
       reception.setTicket_numero(ticket_numero);
       reception.setTicket_date_creation(datesql);
       reception.setTicket_heure_creation(time);
       
       reception.setTicket_top_actif(Boolean.TRUE);
       
       return crud.save(reception);
       //return reception;
    }
    
}