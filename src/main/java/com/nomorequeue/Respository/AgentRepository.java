/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nomorequeue.Respository;

import com.nomorequeue.models.Agent;
import com.nomorequeue.models.Company;
import com.nomorequeue.models.Service;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author CYRILLE DJAMARA
 */
public interface AgentRepository extends CrudRepository<Agent, Long>{
    
    List<Agent> findByCompany(Company company);
    List<Agent> findByCompanyAndService(Company company,Service service);
    Agent findByCompanyAndId(Company company, Long id);
}
