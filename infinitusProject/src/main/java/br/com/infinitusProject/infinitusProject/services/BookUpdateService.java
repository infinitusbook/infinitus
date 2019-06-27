package br.com.infinitusProject.infinitusProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.infinitusProject.infinitusProject.models.BookUpdate;
import br.com.infinitusProject.infinitusProject.models.User;
import br.com.infinitusProject.infinitusProject.repositories.BookUpdateRepository;
import br.com.infinitusProject.infinitusProject.repositories.UserRepository;

@Service("bookUpdateService")
public class BookUpdateService {

	 // Larissa - Classe que implementa os métodos instânciados a partir 
	// do Repositório que utiliza a biblioteca JPA 

	private BookUpdateRepository bookUpdateRepository;
	private UserRepository userRepository;
	
	@Autowired
	public BookUpdateService(BookUpdateRepository bookUpdateRepository, UserRepository userRepository) {
		super();
		this.bookUpdateRepository = bookUpdateRepository;
		this.userRepository = userRepository;
	} 
	
	public void updateBook(@PathVariable("id")  Long id, BookUpdate bookUpdate) {
		User user = userRepository.getOne(id);
		bookUpdate.setUser(user);
		bookUpdate.setAvailable("N");
		bookUpdateRepository.save(bookUpdate); 		
	}
	
	
	
	
	
}
