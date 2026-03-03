package com.orsys.bookservice.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {
	
	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(name = "title")
	@Size(min = 2,max = 120)
	private String title;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "description")
	private String description;
	
	private Boolean publish;
	
	public Book() {
	}

	public Book(String title, 
			String author, 
			String description, 
			Boolean publish) {
		
		this.title = title;
		this.author = author;
		this.description = description;
		this.publish = publish;
	}

	public UUID getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getPublish() {
		return publish;
	}

	public void setPublish(Boolean publish) {
		this.publish = publish;
	}
	
}



