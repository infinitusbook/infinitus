package br.com.JavaEmail.JavaEmail.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.JavaEmail.JavaEmail.models.UserBookQueue;

public interface UserBookQueueRepository extends JpaRepository<UserBookQueue, Long> {
	/*@Query("select 1  position from UserBookQueue")
	int getPosition(); */	
	UserBookQueue findTopByOrderByIdDesc(); 
}
