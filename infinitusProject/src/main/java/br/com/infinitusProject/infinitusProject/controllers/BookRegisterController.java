package br.com.infinitusProject.infinitusProject.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.infinitusProject.infinitusProject.models.Book;
import br.com.infinitusProject.infinitusProject.models.User;
import br.com.infinitusProject.infinitusProject.services.BookService;

@Controller
public class BookRegisterController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/bookRegister", method = RequestMethod.GET)
	public ModelAndView bookRegister(Book book) {
		ModelAndView modelAndView = new ModelAndView(); 
		modelAndView.addObject("book", book);
		modelAndView.setViewName("bookRegister");
		return modelAndView; 
	}
	
	@RequestMapping(value="/bookRegister", method = RequestMethod.POST)
	public ModelAndView createNewBook(@Valid Book book, BindingResult bindingResult, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView(); 
		if(bindingResult.hasErrors()) {
			modelAndView.setViewName("bookRegister");
		} else {
			bookService.saveBook(book);
			modelAndView.addObject("successMessage", "Livro cadastrado com sucesso!");
			modelAndView.addObject("book", book);
			modelAndView.setViewName("bookRegister");			
		}
		return modelAndView;
					
	}
}
