package br.com.JavaEmail.JavaEmail.controllers;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.JavaEmail.JavaEmail.models.Book;
import br.com.JavaEmail.JavaEmail.models.User;
import br.com.JavaEmail.JavaEmail.models.UserBookRequest;
import br.com.JavaEmail.JavaEmail.repositories.BookRepository;
import br.com.JavaEmail.JavaEmail.repositories.UserRepository;

@RestController
public class EmailController {

    @Autowired private JavaMailSender mailSender;
    @Autowired private UserRepository userRepository; 
    @Autowired private BookRepository bookRepository; 
                    
    @CrossOrigin
    @RequestMapping(path = "/email-send/", method = RequestMethod.POST)
    public String sendMail(@RequestBody UserBookRequest userBookRequest) {
    	
    	Book bookId = null;
    	bookId = bookRepository.getOne(userBookRequest.getIdBook());
    	
    	String statusBook = bookRepository.getStatus(bookId.getId());
    	System.err.println(bookId.getId());
    	System.err.println(statusBook);

    	if (statusBook.equalsIgnoreCase("N")){
    		System.out.println("passei por aq");
    		return waitingQueue();
    	} else {    	    	        	 
    	User user = null; 
    	Book book = null; 
    	user = userRepository.findByEmail(userBookRequest.getEmailPersonInterested());
    	book = bookRepository.getOne(userBookRequest.getIdBook());

    	try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail);
            helper.setTo(userBookRequest.getEmailOwner());
            helper.setSubject("Stands - Alguém está interessado no seu livro!" );
            helper.setText(user.getName() + " está interessado no seu livro: " + book.getTitle() 
            + ". Mande um email para " + user.getEmail(), true);
            mailSender.send(mail);
            return "E-mail enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar e-mail.";
        	}
    	}    	
    }
    
    public String waitingQueue() {
    	System.out.println("entrou aq");
    	return "aaa";    	    	
    }
    
}