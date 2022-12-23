/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nomorequeue.Respository;

import com.nomorequeue.models.Traitement;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author CYRILLE DJAMARA
 */
public interface TraitementRepository extends JpaRepository<Traitement, Long> {
    
}
