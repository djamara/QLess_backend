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
public class Company implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank
    @NotNull
    private String company_name;
   
    private Boolean company_topActif = Boolean.TRUE; 
    
    @Nullable
    @OneToOne
    Industry industry;
    
    @Nullable
    String industry_other;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Boolean getCompany_topActif() {
        return company_topActif;
    }

    public void setCompany_topActif(Boolean company_topActif) {
        this.company_topActif = company_topActif;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public String getIndustry_other() {
        return industry_other;
    }

    public void setIndustry_other(String industry_other) {
        this.industry_other = industry_other;
    }
    
      
}
