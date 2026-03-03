package com.orsys.bookservice.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orsys.bookservice.models.Book;

@Repository
public interface BookDAO extends JpaRepository<Book, UUID>{
	Optional<List<Book>> findByTitle(String title);
}
