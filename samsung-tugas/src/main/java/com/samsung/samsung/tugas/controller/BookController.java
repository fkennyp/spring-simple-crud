package com.samsung.samsung.tugas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.samsung.samsung.tugas.entity.Books;
import com.samsung.samsung.tugas.handler.Response;
import com.samsung.samsung.tugas.service.BookService;

@RestController
public class BookController {
	@Autowired 
	BookService bookService;
	
	@GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Response> getAllBooks(){
		return bookService.getAllBooksService();
	}
	
	@GetMapping(value = "/book/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Response> getBookById(@PathVariable(name = "bookId") Long bookId) {
		return bookService.getBookByIdService(bookId);
	}
	
	@DeleteMapping(value = "/book/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Response> deleteBook(@PathVariable(name = "bookId") Long bookId) {
		return bookService.deleteBookService(bookId);
	}
	
	@PostMapping(value = "/book/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Response> addBook(@RequestBody Books newBook) {
		return bookService.addBookService(newBook);
	}
	
	@PutMapping(value = "/book/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Response> update(@RequestBody Books updateBook) {
		return bookService.updateBookService(updateBook);
	}
}
