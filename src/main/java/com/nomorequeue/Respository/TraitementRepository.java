/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nomorequeue.Respository;

import com.nomorequeue.models.Agent;
import com.nomorequeue.models.Company;
import com.nomorequeue.models.Traitement;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author CYRILLE DJAMARA
 */
public interface TraitementRepository extends JpaRepository<Traitement, Long> {
    List<Traitement> findByCompany(Company company);
    List<Traitement> findByCompanyAndStatus(Company company,String status);
    List<Traitement> findByCompanyAndStatusAndAgent(Company company,String status,Agent agent);
    
    @Query(value="SELECT *,TIME_FORMAT(AVG(cast(traitement.ticket_heure_update AS TIME)),\"%T\") AS duree_traitement "
            + "FROM traitement "
            + "WHERE (traitement.`status` ='termine' OR traitement.`status`='en_traitement') "
            + "GROUP BY traitement.reception_id",
            nativeQuery=true)
    List<Traitement>getAllTraitTermine();
    
    @Query(
    value="SELECT * FROM traitement "
            + "WHERE (traitement.`status`='termine' OR traitement.`status`='transferer') "
            + "AND traitement.agent_id = :agent_id "
            + "AND company_id= :company_id",
    nativeQuery = true)
    List<Traitement> getAllTerminAndTransf(@Param("company_id") Long company_id, @Param("agent_id") Long agent_id);
    
    
    
}
