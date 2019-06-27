package com.infinitusBooks.searchBooks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infinitusBooks.searchBooks.models.BookUpdate;

@Repository
public interface BookUpdateRepository extends JpaRepository<BookUpdate, Long>{
	@Query("from BookUpdate where action=?1 and user_id=?2")
	List<BookUpdate> searchBooksByActionAndId(String action, Long id);
}
