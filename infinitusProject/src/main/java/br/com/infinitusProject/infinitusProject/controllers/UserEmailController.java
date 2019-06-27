package br.com.infinitusProject.infinitusProject.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import br.com.infinitusProject.infinitusProject.models.User;

@RestController
public class UserEmailController {
	
	@Autowired 
	private HttpSession session; 
	
	@CrossOrigin
	@RequestMapping(value = "/email", method = RequestMethod.GET)
	public ResponseEntity<String> userEmail() {
		String email = (String) session.getAttribute("email");  
		return ResponseEntity.ok(email); 
	}	
	
	@CrossOrigin
	@RequestMapping(value = "/id", method = RequestMethod.GET)
	public ResponseEntity<Long> userId() {
		Long userId = Long.parseLong(session.getAttribute("id").toString()); 
		return ResponseEntity.ok(userId); 
	}	

}
