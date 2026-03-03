package com.orsys.orderService.dto;

import java.util.UUID;

public class BookDto {
	
	private UUID idBook;
	
	private String title;

	private String author;
	
	private String description;
	
	private Boolean publish;

	public UUID getIdBook() {
		return idBook;
	}

	public void setIdBook(UUID idBook) {
		this.idBook = idBook;
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
