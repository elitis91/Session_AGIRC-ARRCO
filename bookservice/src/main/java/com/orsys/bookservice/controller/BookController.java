package com.orsys.bookservice.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orsys.bookservice.models.Book;
import com.orsys.bookservice.service.BookService;

@RequestMapping(path = "/api/v1/books",produces ="application/json" )
@RestController
@CrossOrigin(origins = "*")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping(path = "")
	ResponseEntity<List<Book>> getBooks(){
		try {
			return new ResponseEntity<List<Book>>(
					bookService.getBooks(),
					HttpStatus.OK
					);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR
					);
		}
	}
	
	@GetMapping(path = "/{id}")
	ResponseEntity<Book> getBookById(@PathVariable UUID id){
		try {
			return new ResponseEntity<Book>(
					bookService.getBookById(id),
					HttpStatus.OK
					);
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR
					);
		}
	}
	
	@PostMapping(path = "")
	ResponseEntity<Book> createBook(@RequestBody Book book){
		try {
			return new ResponseEntity<Book>(
					bookService.createBook(book),
					HttpStatus.CREATED
					);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR
					);
		}
	}
	
	@PutMapping(path = "/{id}")
	ResponseEntity<Book> updateBook(@PathVariable UUID id,@RequestBody Book book){
		try {
			return new ResponseEntity<Book>(
					bookService.updateBook(id, book),
					HttpStatus.ACCEPTED
					);
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			return new ResponseEntity<>(
					HttpStatus.NOT_FOUND
					);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR
					);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	ResponseEntity<HttpStatus> deleteBookById(@PathVariable UUID id){
		try {
			bookService.deleteBookById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR
					);
		}
	}
}
