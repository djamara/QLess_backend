/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nomorequeue.Respository;


import com.nomorequeue.models.Company;
import com.nomorequeue.models.Reception;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author CYRILLE DJAMARA
 */
@Repository
public interface ReceptionRepository extends JpaRepository<Reception, Long> {
    //@Query(name="SELECT r FROM reception r WHERE upper(r.company.id) = :company", nativeQuery = true)
    //List<Reception> getReceptionByCompany(@Param("company") Long company);
    List<Reception> findByCompany(Company company);
    
    @Query(value="SELECT COUNT(r.id) AS weeklycount FROM reception r "
            + "WHERE r.company_id =:company "
            + "AND WEEK(r.ticket_date_creation) = WEEK(:zae)", 
    nativeQuery = true)
    int getWeeklyReceptionCountByCompany(@Param("company") Long company , @Param("zae") String zae);
    
    @Query(value="SELECT COUNT(r.id) AS weeklycount FROM reception r "
            + "WHERE r.company_id = :company "
            + "AND r.ticket_top_actif= :topActif", 
    nativeQuery = true)
    int ReceptionCountByCompanyTop(@Param("company") Long company , @Param("topActif") String topActif);
    
    @Query(value="SELECT COUNT(r.id) AS weeklycount, r.ticket_top_actif "
            + "FROM reception r "
            + "WHERE r.company_id =:company AND "
            + "WEEK(r.ticket_date_creation)= WEEK(:zae) "
            + "GROUP BY r.ticket_top_actif "
            + "ORDER BY week(r.ticket_date_creation) ASC ", 
            nativeQuery = true)
    List<Object> countWeeklyrecp(@Param("company") Long company , @Param("zae") String zae);
}
