package com.infinitusBooks.searchBooks.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.infinitusBooks.searchBooks.models.Book;
import com.infinitusBooks.searchBooks.models.BookUpdate;
import com.infinitusBooks.searchBooks.models.User;
import com.infinitusBooks.searchBooks.repositories.BookRepository;
import com.infinitusBooks.searchBooks.repositories.BookUpdateRepository;
import com.infinitusBooks.searchBooks.repositories.UserRepository;

@Service("bookService")
public class BookService {
	
	 // Larissa - Classe que implementa os métodos instânciados a partir 
		// do Repositório que utiliza a biblioteca JPA 
	
	private BookRepository bookRepository;
	private BookUpdateRepository bookUpdateRepository;
	private UserRepository userRepository; 

	@Autowired
	public BookService(BookRepository bookRepository, UserRepository userRepository, BookUpdateRepository bookUpdateRepository) {
		this.bookRepository = bookRepository;
		this.userRepository = userRepository; 
		this.bookUpdateRepository = bookUpdateRepository;
	} 
	
	public void saveBook(@PathVariable("id") Long id, Book book) {
		User user = userRepository.getOne(id); 
		book.setUser(user);			
		bookRepository.save(book); 
	}
	
	public void isAvailable(Book book, List<Book> books) {
		if(book.getAvailable().equals("Y")) {
			book.setAvailable("Disponível");
			books.add(book);
		} else {
			book.setAvailable("Indisponível");
			books.add(book);
		}		
	}
	
	public List<Book> searchBooks() {
		List<Book> books = new ArrayList<Book>();
		for (Book book : bookRepository.searchBooks()) {
			isAvailable(book, books); 
		}
		return books;
	}
	
	public List<Book> searchBooksById(Long userId) {
		List<Book> books = new ArrayList<Book>();
		for(Book book : bookRepository.searchBooksById(userId)){
			isAvailable(book, books); 
		}
		return books;		
	}
	 
	public List<Book> searchBooksByAction(String action){
		List<Book> books = new ArrayList<Book>();
		for(Book book : bookRepository.searchBooksByAction(action)) {
			isAvailable(book, books); 
		}
		return books;	
	}
	
	public List<BookUpdate> searchBooksByActionAndId(String action, Long userId){
		List<BookUpdate> books = new ArrayList<BookUpdate>();
		for(BookUpdate book : bookUpdateRepository.searchBooksByActionAndId(action, userId)) {
			if(book.getAvailable().equals("Y")) {
				book.setAvailable("Disponível");
				books.add(book);
			} else {
				book.setAvailable("Indisponível");
				books.add(book);
			}		
		}
		return books;	
	}
}
