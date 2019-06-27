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

	@RequestMapping(value = "/donatedBooks", method = RequestMethod.GET) 
	public ModelAndView donatedBooks() {
		ModelAndView modelAndView = new ModelAndView(); 
		modelAndView.setViewName("donatedBooks");
		return modelAndView; 
	}		

	@RequestMapping(value = "/exchangedBooks", method = RequestMethod.GET) 
	public ModelAndView exchangedBooks() {
		ModelAndView modelAndView = new ModelAndView(); 
		modelAndView.setViewName("exchangedBooks");
		return modelAndView; 
	}		

	@RequestMapping(value = "/borrowedBooks", method = RequestMethod.GET) 
	public ModelAndView borrowedBooks() {
		ModelAndView modelAndView = new ModelAndView(); 
		modelAndView.setViewName("borrowedBooks");
		return modelAndView; 
	}		
}
