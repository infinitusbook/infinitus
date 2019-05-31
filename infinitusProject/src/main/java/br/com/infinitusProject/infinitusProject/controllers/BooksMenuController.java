package br.com.infinitusProject.infinitusProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BooksMenuController {
	
	@RequestMapping(value = "/myBooks", method = RequestMethod.GET) 
	public ModelAndView myBooks() {
		ModelAndView modelAndView = new ModelAndView(); 
		modelAndView.setViewName("myBooks");
		return modelAndView; 
	}		

}
