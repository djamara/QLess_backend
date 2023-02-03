/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nomorequeue.controllers;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.nomorequeue.Respository.CompanyRepository;
import com.nomorequeue.Respository.EventRepository;
import com.nomorequeue.Respository.PersonRepository;
import com.nomorequeue.Respository.RegistrationRepository;
import com.nomorequeue.models.Company;
import com.nomorequeue.models.Event;
import com.nomorequeue.models.Person;
import com.nomorequeue.models.Registration;
import com.nomorequeue.models.Service;
import jakarta.validation.Valid;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.zxing.qrcode.QRCodeWriter;
import com.nomrequeue.codeqr.QRCodeGenerator;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author CYRILLE DJAMARA
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/event")
public class RegistrationController {
    
    @Autowired
    RegistrationRepository registration_crud;
    
    @Autowired
    PersonRepository person_crud;
    
    @Autowired
    EventRepository event_crud;
    
    @Autowired
    CompanyRepository company_crud;
    
    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/img/QRCode.png";
    
    @PostMapping("/add-registration")
    public Registration addRegistration(@Valid @RequestBody Registration registration){
        
        //registration.setPerson(person_crud.save(registration.getPerson()));
       Calendar cal = Calendar.getInstance();
       
       Date date = new Date();
       Timestamp time = new Timestamp(System.currentTimeMillis());
       java.sql.Date datesql = new java.sql.Date(date.getTime());
       
       registration.setRegistration_date(datesql);
       registration.setRegistration_heure(time);
       
       Event event = this.event_crud.save(registration.getEvent());
       registration.setEvent(event);
       
       Person person = registration.getPerson();
       Company company = registration.getPerson().getCompany();
       if(company != null){
           this.company_crud.save(company);
           person.setCompany(company);
       }
       
       person = this.person_crud.save(person);
       
       registration.setPerson(person);
       
       registration = this.registration_crud.save(registration);
       
       this.getQrCode(registration.getId().toString());
       
       return registration;
    }
    
    @GetMapping("/get-all-registration")
    public Iterable<Registration> getAllRegistration(){
        return registration_crud.findAll();
    }
    
    @GetMapping("/getqrcode")
    public String getQrCode(String id){
        
        String medium="https://rahul26021999.medium.com/";
        String github="https://localhost:4200/#/display/"+id;
        
        byte[] image = new byte[0];
        try{
            // Generate and Return Qr Code in Byte Array
            image = QRCodeGenerator.getQRCodeImage(medium,250,250);

            // Generate and Save Qr Code Image in static/image folder
            QRCodeGenerator.generateQRCodeImage(github,250,250,QR_CODE_IMAGE_PATH);
        }
        catch(WriterException | IOException e) {
        }
        
        // Convert Byte Array into Base64 Encode String
        String qrcode = Base64.getEncoder().encodeToString(image);
        
        return "";
    }
    
    @PostMapping("/send-email")
    public void sendMail() {
        String to = "sonoojaiswal1988@gmail.com";//change accordingly  
        String from = "djamaracyrille@gmail.com";//change accordingly  
        String host = "localhost";//or IP address 
        
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");  
          
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {    
           @Override
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,"Mercijesus92*");  
           } 
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("djamaracyrille@gmail.com"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress("djamara.edju@gmail.com"));
            msg.setSubject("Your email test has been sent");
            msg.setText("This is a test");
            Transport.send(msg);
        } catch (AddressException e) {
            // ...
        }catch (MessagingException e) {
            // ...
        }
        
    }
}
