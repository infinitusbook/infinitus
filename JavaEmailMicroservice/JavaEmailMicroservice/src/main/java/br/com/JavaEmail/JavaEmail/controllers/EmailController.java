package br.com.JavaEmail.JavaEmail.controllers;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired private JavaMailSender mailSender;

    @RequestMapping(path = "/email-send", method = RequestMethod.GET)
    public String sendMail() {
        try {
            MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper( mail );
            helper.setTo( "lari3573@outlook.com" );
            helper.setSubject( "Teste Envio de e-mail" );
            helper.setText("<p>Hello, Spring Boot</p>", true);
            mailSender.send(mail);

            return "E-mail enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar e-mail.";
        }
    }
}