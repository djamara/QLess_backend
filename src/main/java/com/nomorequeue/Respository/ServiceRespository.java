/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nomorequeue.Respository;

import com.nomorequeue.models.Company;
import com.nomorequeue.models.Service;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author CYRILLE DJAMARA
 */
public interface ServiceRespository extends JpaRepository<Service, Long>{
    
    List<Service> findByCompany(Company company);
    Service findByCompanyAndId(Company company,Long id);
}
