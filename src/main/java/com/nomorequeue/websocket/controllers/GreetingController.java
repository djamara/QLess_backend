/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nomorequeue.websocket.controllers;

import com.nomorequeue.websocket.Greeting;
import com.nomorequeue.websocket.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

/**
 *
 * @author CYRILLE DJAMARA
 */
@Controller
public class GreetingController {
    
    
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(String ticket_number){
        //return new Greeting("Hello, " + HtmlUtils.htmlEscape(ticket_number) + "!");
        return ticket_number;
    }
    
    @MessageMapping("/transfert")
    @SendTo("/topic/transfert")
    public String transfert(String destinataire){
        //return new Greeting("Hello, " + HtmlUtils.htmlEscape(ticket_number) + "!");
        return destinataire;
    }
    
    @MessageMapping("/hel")
    @SendTo("/topic/greetin")
    public String feeback(Message message){
        return message.getText();
    }
}
