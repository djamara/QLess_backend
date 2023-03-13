/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nomorequeue.Respository;

import com.nomorequeue.models.Company;
import com.nomorequeue.models.Role;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author CYRILLE DJAMARA
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    
    List<Role> findByCompany(Company company);
    Role findByCompanyAndId(Company company, Long Id);
}
