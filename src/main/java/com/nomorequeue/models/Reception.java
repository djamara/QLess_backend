/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nomorequeue.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author CYRILLE DJAMARA
 */
@Entity
public class Reception implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank
    @NotNull
    private String nom;
    
    @NotBlank
    @NotNull
    private String prenom;
    
    @NotBlank
    @NotNull
    private String phone1;
    private String phone2;
    
    private String ticket_numero;
    
    private Date ticket_date_creation;
    private Timestamp ticket_heure_creation;
    
    @Valid
    @OneToOne
    private TypeReception typeRecep;
    
    @Valid
    @OneToOne
    @Nullable
    private Operation operation;
    
    @Valid
    @OneToOne
    @Nullable
    private Agent agentVisite;
    
    @OneToOne
    private Company company;
     
    private int ticket_top_actif = 1;

    public Agent getAgentVisite() {
        return agentVisite;
    }

    public void setAgentVisite(Agent agentVisite) {
        this.agentVisite = agentVisite;
    }

    
    public TypeReception getTypeRecep() {
        return typeRecep;
    }

    public void setTypeRecep(TypeReception typeRecep) {
        this.typeRecep = typeRecep;
    }
    
    
     public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getTicket_numero() {
        return ticket_numero;
    }

    public void setTicket_numero(String ticket_numero) {
        this.ticket_numero = ticket_numero;
    }

    public Date getTicket_date_creation() {
        return ticket_date_creation;
    }

    public void setTicket_date_creation(Date ticket_date_creation) {
        this.ticket_date_creation = ticket_date_creation;
    }

    public Timestamp getTicket_heure_creation() {
        return ticket_heure_creation;
    }

    public void setTicket_heure_creation(Timestamp ticket_heure_creation) {
        this.ticket_heure_creation = ticket_heure_creation;
    }
    
    public int getTicket_top_actif() {
        return ticket_top_actif;
    }

    public void setTicket_top_actif(int ticket_top_actif) {
        this.ticket_top_actif = ticket_top_actif;
    }

}
