package com.samsung.samsung.tugas.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.samsung.samsung.tugas.entity.Books;

public interface BookRepository extends JpaRepository<Books, Long>{
	@Query(value = "SELECT id, author, name, price, created_at "
				 + "FROM books;", nativeQuery = true)
	List<Books> getAllBooks();
	
	@Query(value = "SELECT b.id, b.author, b.name, b.price, b.created_at "
				 + "FROM books b "
				 + "WHERE b.id = ?1", nativeQuery = true)
	Optional<Books> getBookById(Long bookId);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM books b WHERE b.id = ?1", nativeQuery = true)
	int deleteBookById(Long bookId);
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO books (author, name, price, created_at) VALUES (?1, ?2, ?3, NOW());", nativeQuery = true)
	int addBook(String author, String name, Integer price);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE books b "
				 + "SET b.author = ?1, b.name = ?2, b.price = ?3 "
			     + "WHERE b.id = ?4", nativeQuery = true)
	int updateBook(String author, String name, Integer price, Long id);
}
