package br.com.infinitusProject.infinitusProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.infinitusProject.infinitusProject.models.BookUpdate;

@Repository
public interface BookUpdateRepository extends JpaRepository<BookUpdate, Long>{

}
