package br.com.JavaEmail.JavaEmail.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.JavaEmail.JavaEmail.models.Book;


@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, Long> {
	//Larissa - Interface que extende a biblioteca JPA para manipulação de métodos vinculados aos Livros 
	@Query("select available from Book where id=?1")
	String getStatus(Long id); 
} 