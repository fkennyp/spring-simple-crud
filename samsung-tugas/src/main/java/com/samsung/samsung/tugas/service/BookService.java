package com.samsung.samsung.tugas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.samsung.samsung.tugas.entity.Books;
import com.samsung.samsung.tugas.handler.Response;
import com.samsung.samsung.tugas.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	
	public ResponseEntity<Response> getAllBooksService(){
		List<Books> allBooks = bookRepository.getAllBooks();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response(202, "Data all books", allBooks));
	}
	
	public ResponseEntity<Response> getBookByIdService(Long bookId) {
		Optional<Books> searchedBook = bookRepository.getBookById(bookId);
		if(searchedBook.isPresent()) {			
			return ResponseEntity.status(HttpStatus.OK).body(new Response(200, "Get book detail success", searchedBook.get()));
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new Response(403, "Fail to get Book Detail", null));
	}
	
	public ResponseEntity<Response> deleteBookService(Long bookId) {
		Optional<Books> wantToDeleteBook = bookRepository.getBookById(bookId);
		int result = bookRepository.deleteBookById(bookId);
		if(result == 1) {
			return ResponseEntity.status(HttpStatus.OK).body(new Response(200, "success delete book. Deleted book: ", wantToDeleteBook));
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new Response(403, "Failed delete book", null));
	}
	
	public ResponseEntity<Response> addBookService(Books newBook) {
		int result = bookRepository.addBook(newBook.getAuthor(), newBook.getName(), newBook.getPrice());
		if(result == 1) {
			long addedBookId = bookRepository.count();
			Optional<Books> createdBook = bookRepository.getBookById(addedBookId);
			return ResponseEntity.status(HttpStatus.OK).body(new Response(200, "New Book Created", createdBook.get()));
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new Response(403, "Fail Create New Book", null));
	}
	
	public ResponseEntity<Response> updateBookService(Books updateBook) {
		int result = bookRepository.updateBook(updateBook.getAuthor(), updateBook.getName(), updateBook.getPrice(), updateBook.getId());
		if(result == 1) {
			Optional<Books> updatedBook = bookRepository.getBookById(updateBook.getId());
			return ResponseEntity.status(HttpStatus.OK).body(new Response(200, "Book updated", updatedBook));
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new Response(403, "Fail to update book", null));
	}
}
