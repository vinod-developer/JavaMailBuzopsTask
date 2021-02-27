package com.example.buzopsFeb4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SendEmailController {



    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailRepository emailRepository;

    @PostMapping("/sendemail")
    public String send(@RequestBody Email email) {
        emailService.sendEmail(email);
        return "Email sent successfully";
    }

    @GetMapping("/getEmails")
    public List<Email> retrieveToMails(){
       return (List<Email>) emailRepository.findAll();
    }



}
