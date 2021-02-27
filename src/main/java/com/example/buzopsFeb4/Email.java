package com.example.buzopsFeb4;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@Setter
@Entity
public class Email {

        @Id
        @GeneratedValue
        private int id;
        private String subject;
        private String  fromEmail;
        private String emailBody;
        private String  companyName;
        private String fromName;
        private String  sendTo;

        public  Email(){

        }


        public Email(String subject, String fromEmail, String emailBody, String companyName, String fromName, String sendTo) {
            super();
            this.subject = subject;
            this.fromEmail = fromEmail;
            this.emailBody = emailBody;
            this.companyName = companyName;
            this.fromName = fromName;
            this.sendTo = sendTo;
        }

    }
