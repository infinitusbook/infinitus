package com.infinitusBooks.searchBooks.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.infinitusBooks.searchBooks.models.Book;
import com.infinitusBooks.searchBooks.services.BookService;

@RestController
@RequestMapping("/book")
public class BookRestController {
	
	@Autowired
	private BookService bookService;	
	
	@CrossOrigin
	@GetMapping("/")
	public ResponseEntity<List<Book>> searchBooks() {
		return ResponseEntity.ok(bookService.searchBooks());
	}
	    
	@CrossOrigin
	@GetMapping("/my-book/{id}")
	public ResponseEntity<List<Book>> searchBooksUser(@PathVariable("id") Long id) {
		return ResponseEntity.ok(bookService.searchBooksById(id)); 
	}
		
	@CrossOrigin
	@GetMapping("/donate")
	public ResponseEntity<List<Book>> searchBooksByActionDonate() {
		return ResponseEntity.ok(bookService.searchBooksByAction("Doar"));
	}
	
	@CrossOrigin
	@GetMapping("/exchange")
	public ResponseEntity<List<Book>> searchBooksByActionExchange() {
		return ResponseEntity.ok(bookService.searchBooksByAction("Trocar"));
	}
		
	@CrossOrigin
	@GetMapping("/borrow")
	public ResponseEntity<List<Book>> searchBooksByActionBorrow() {
		return ResponseEntity.ok(bookService.searchBooksByAction("Emprestar"));
	}
}
 