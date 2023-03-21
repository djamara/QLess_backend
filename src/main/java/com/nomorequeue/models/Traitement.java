/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nomorequeue.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import org.springframework.data.relational.core.mapping.Column;

/**
 *
 * @author CYRILLE DJAMARA
 */
@Entity
public class Traitement implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    private Reception reception;
    
    @OneToOne
    private Agent agent;
    
    @Nullable
    @OneToOne
    private Agent recipiendaire;
    
    @NotNull
    @OneToOne
    private Company company;
    
    private String status;
    
    private String commentaire;
    
    private Date ticket_date_update;
    
    private Timestamp ticket_heure_update;
    
    private Time duree_traitement;
    private Boolean traitement_topActif = Boolean.TRUE;

    public Time getDuree_traitement() {
        return duree_traitement;
    }

    public void setDuree_traitement(Time duree_traitement) {
        this.duree_traitement = duree_traitement;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
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

    public Agent getRecipiendaire() {
        return recipiendaire;
    }

    public void setRecipiendaire(Agent recipiendaire) {
        this.recipiendaire = recipiendaire;
    }

    public Reception getReception() {
        return reception;
    }

    public void setReception(Reception reception) {
        this.reception = reception;
    }

    public Agent getAgent() {
        return agent;
    }
    
    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Date getTicket_date_update() {
        return ticket_date_update;
    }

    public void setTicket_date_update(Date ticket_date_update) {
        this.ticket_date_update = ticket_date_update;
    }

    public Timestamp getTicket_heure_update() {
        return ticket_heure_update;
    }

    public void setTicket_heure_update(Timestamp ticket_heure_update) {
        this.ticket_heure_update = ticket_heure_update;
    }

    public Boolean getTraitement_topActif() {
        return traitement_topActif;
    }

    public void setTraitement_topActif(Boolean traitement_topActif) {
        this.traitement_topActif = traitement_topActif;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
