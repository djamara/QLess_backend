/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nomorequeue.Respository;


import com.nomorequeue.models.Company;
import com.nomorequeue.models.TypeReception;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author CYRILLE DJAMARA
 */
public interface TypeReceptionRepository extends JpaRepository<TypeReception, Long> {
    List<TypeReception> findByCompany(Company company);
}
