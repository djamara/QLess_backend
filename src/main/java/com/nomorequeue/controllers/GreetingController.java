/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nomorequeue.controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author CYRILLE DJAMARA
 */
@RestController 
public class GreetingController {
    
    @GetMapping("/greeting")
    public String greeting(){
        return "Pour dire le Bonjour";
    }
    
}
