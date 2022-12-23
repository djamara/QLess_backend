/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nomorequeue.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author CYRILLE DJAMARA
 */
@Entity
public class Traitement implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    private Reception reception;
    
    @OneToOne
    private Agent agent;
    private String status;
            
    private Date ticket_date_update;
    private Timestamp ticket_heure_update;
    private Boolean traitement_topActif = Boolean.TRUE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
