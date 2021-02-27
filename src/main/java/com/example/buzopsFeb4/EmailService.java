package com.example.buzopsFeb4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class EmailService {

    @Autowired
   private JavaMailSender javaMailSender;

    @Autowired
    private EmailRepository emailRepository;

    public void sendEmail(Email email) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(email.getFromEmail().toString());
        msg.setSubject(email.getSubject().toString());
        msg.setText(email.getEmailBody().toString());
        msg.setTo(email.getSendTo().toString());
        javaMailSender.send(msg);

    }

    public void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();


        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        //helper.setTo("vinod.allam74@gmail.com");
        helper.setTo(new String[]{"vinod.allam74@gmail.com","vinod.allam512@gmail.com"});

        helper.setSubject("Testing for Spring Boot attachment jan 20");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);

        // hard coded a file path
        FileSystemResource file = new FileSystemResource(new File("C:/harvard_ui.jpg"));

        helper.addAttachment("harvard_ui.jpg", file);

        javaMailSender.send(msg);

    }


//    public List<Email> retrieveDetails() {
//        return (List<Email>) emailRepository.findAll();
//    }
}
