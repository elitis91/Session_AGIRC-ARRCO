package com.orsys.bookservice.service;

import java.util.List;
import java.util.UUID;

import com.orsys.bookservice.models.Book;

public interface BookService {
	
	List<Book> getBooks();
	
	Book getBookById(UUID id);
	
	
	Book createBook(Book book);
	
	Book updateBook(UUID id,Book book);
	
	void deleteBookById(UUID id);

}
