package com.infinitusBooks.searchBooks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infinitusBooks.searchBooks.models.Book;

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, Long> {
	//Larissa - Interface que extende a biblioteca JPA para manipulação de métodos vinculados aos Livros 
	@Query("from Book where available = 'Y'")
	List<Book> searchBooks(); 
	
	
}
