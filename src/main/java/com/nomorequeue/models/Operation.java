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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author CYRILLE DJAMARA
 */
@Entity
public class Operation implements Serializable {
       
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank
    @NotNull
    private String libelle;
    
    @NotBlank
    @NotNull
    private String estimation_temps;
    
    @OneToOne
    @Nullable
    private Service service;
    
    @Nullable
    @OneToOne
    private Company company;
    
    private Boolean role_topActif = Boolean.TRUE;

    public String getEstimation_temps() {
        return estimation_temps;
    }

    public void setEstimation_temps(String estimation_temps) {
        this.estimation_temps = estimation_temps;
    }
    

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Boolean getRole_topActif() {
        return role_topActif;
    }

    public void setRole_topActif(Boolean role_topActif) {
        this.role_topActif = role_topActif;
    }
    
    
    
}
