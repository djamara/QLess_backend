/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nomorequeue.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author CYRILLE DJAMARA
 */
@Entity
public class QualityGuess implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank
    @NotNull
    private String quality_name;
    
    private Boolean quality_topActif = Boolean.TRUE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuality_name() {
        return quality_name;
    }

    public void setQuality_name(String quality_name) {
        this.quality_name = quality_name;
    }

    public Boolean getQuality_topActif() {
        return quality_topActif;
    }

    public void setQuality_topActif(Boolean quality_topActif) {
        this.quality_topActif = quality_topActif;
    }
    
}
