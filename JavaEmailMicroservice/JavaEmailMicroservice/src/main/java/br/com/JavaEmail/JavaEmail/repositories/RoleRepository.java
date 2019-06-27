package br.com.JavaEmail.JavaEmail.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.JavaEmail.JavaEmail.models.Role;


@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
	//Larissa - Interface que extende a biblioteca JPA para manipulação de métodos vinculados aos Papéis 
    Role findByRole(String role);
}