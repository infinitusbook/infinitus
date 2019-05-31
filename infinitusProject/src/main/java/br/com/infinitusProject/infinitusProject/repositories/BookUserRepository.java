package br.com.infinitusProject.infinitusProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.infinitusProject.infinitusProject.models.BookUser;

public interface BookUserRepository extends JpaRepository<BookUser, Long>{

}
