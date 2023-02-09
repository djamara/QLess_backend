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
public class Registration implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
    @NotNull
    @OneToOne
    private Event event;
    
    @NotNull
    @OneToOne
    private Person person;
    
    @NotNull
    @OneToOne        
    private RegistrationType regtype;
    
    @NotNull
    @OneToOne        
    private QualityGuess quality;
    
    private Date registration_date;
    private Timestamp registration_heure;
    
    private Boolean registration_topActif = Boolean.TRUE; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public RegistrationType getRegtype() {
        return regtype;
    }

    public void setRegtype(RegistrationType regtype) {
        this.regtype = regtype;
    }

    public QualityGuess getQuality() {
        return quality;
    }

    public void setQuality(QualityGuess quality) {
        this.quality = quality;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public Timestamp getRegistration_heure() {
        return registration_heure;
    }

    public void setRegistration_heure(Timestamp registration_heure) {
        this.registration_heure = registration_heure;
    }

    public Boolean getRegistration_topActif() {
        return registration_topActif;
    }

    public void setRegistration_topActif(Boolean registration_topActif) {
        this.registration_topActif = registration_topActif;
    }
    
    
}
