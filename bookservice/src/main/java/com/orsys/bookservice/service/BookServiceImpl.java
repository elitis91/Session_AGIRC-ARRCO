package com.orsys.bookservice.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orsys.bookservice.dao.BookDAO;
import com.orsys.bookservice.models.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDAO bookDAO;

	@Override
	public List<Book> getBooks() {
		return bookDAO.findAll();
	}

	@Override
	public Book getBookById(UUID id) {
		return bookDAO.findById(id).orElseThrow(
				() -> new IllegalArgumentException("BOOK NOT FOUND")
		);
	}

	@Override
	public Book createBook(Book book) {
		return bookDAO.save(book);
	}

	@Override
	public Book updateBook(UUID id, Book book) {
		Book _book = bookDAO.findById(id).orElseThrow(
				() -> new IllegalArgumentException("BOOK NOT FOUND")
				);
		
		_book.setAuthor(book.getAuthor());
		_book.setDescription(book.getDescription());
		_book.setTitle(book.getTitle());
		_book.setPublish(book.getPublish());
		
		return bookDAO.save(_book);
	}

	@Override
	public void deleteBookById(UUID id) {
		bookDAO.deleteById(id);
		
	}


}
