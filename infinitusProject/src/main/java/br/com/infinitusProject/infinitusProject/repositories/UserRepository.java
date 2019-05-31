package br.com.infinitusProject.infinitusProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.infinitusProject.infinitusProject.models.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
	//Larissa - Interface que extende a biblioteca JPA para manipulação de métodos vinculados aos Usuários 
	 User findByEmail(String email); 
}
