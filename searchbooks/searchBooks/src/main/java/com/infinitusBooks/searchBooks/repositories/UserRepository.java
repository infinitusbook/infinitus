package com.infinitusBooks.searchBooks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinitusBooks.searchBooks.models.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
	//Larissa - Interface que extende a biblioteca JPA para manipulação de métodos vinculados aos Usuários 
	 User findByEmail(String email); 
}
