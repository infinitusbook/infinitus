package br.com.infinitusProject.infinitusProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.infinitusProject.infinitusProject.models.Book;
import br.com.infinitusProject.infinitusProject.models.User;

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, Long> {
	//Larissa - Interface que extende a biblioteca JPA para manipulação de métodos vinculados aos Livros 
}
