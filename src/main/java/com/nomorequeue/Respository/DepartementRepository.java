/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nomorequeue.Respository;
import com.nomorequeue.models.Company;
import com.nomorequeue.models.Departement;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author CYRILLE DJAMARA
 */
public interface DepartementRepository extends CrudRepository<Departement,Long> {
    
    List<Departement> findByCompany(Company company);
}
