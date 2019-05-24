package com.infinitusBooks.searchBooks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}
