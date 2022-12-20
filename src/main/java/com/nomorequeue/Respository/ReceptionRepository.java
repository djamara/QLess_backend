/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nomorequeue.Respository;


import com.nomorequeue.models.Company;
import com.nomorequeue.models.Reception;
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
}
