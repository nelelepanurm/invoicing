package com.schoolproject.invoicing;

import jdk.jfr.Registered;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.PasswordAuthentication;
import java.util.Properties;

    /* public class TestController {

    //SENDING EMAIL
    /* @PostMapping("sendEmail")
    public void sendEmail() throws MessagingException {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", true);
        prop.put("mail.smtp.starttls.enable", "smtp.gmail.com");
        prop.put("mail.smtp.host", "587");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("user", "password"); //siin tuleb mingid actual paroolid ja passwordid (luua mingi uus fake konto)
                    }
                }
        );

        Message message = new MineMessage(session);
        message.setFrom(new InternetAddress("meieloodud@gmail.aadress"));
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse("to@gmail.com")
        );
        message.setSubject("Subject");
        message.setText("Body of email");
        Transport.send(message);
    } */




