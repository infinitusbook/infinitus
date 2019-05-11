package br.com.infinitusProject.infinitusProject.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.infinitusProject.infinitusProject.models.Book;
import br.com.infinitusProject.infinitusProject.models.User;
import br.com.infinitusProject.infinitusProject.repositories.BookRepository;
import br.com.infinitusProject.infinitusProject.repositories.UserRepository;

@Service("bookService")
public class BookService {
	
	 // Larissa - Classe que implementa os métodos instânciados a partir 
		// do Repositório que utiliza a biblioteca JPA 
	
	private BookRepository bookRepository;
	private UserRepository userRepository; 

	@Autowired
	public BookService(BookRepository bookRepository, UserRepository userRepository) {
		this.bookRepository = bookRepository;
		this.userRepository = userRepository; 
	} 
	
	public void saveBook(@PathVariable("id") Long id, Book book) {
		User user = userRepository.getOne(id); 
		book.setUser(user);			
		bookRepository.save(book); 
	}
	
	 
}
