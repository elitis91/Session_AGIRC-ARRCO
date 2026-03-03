package com.orsys.orderService.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	private UUID idBook;
	
	private String title;
	
	private Integer qte;
	
	private OrderStatus status;
	
	public Order() {}

	public Order(UUID idBook, Integer qte) {
		this.idBook = idBook;
		this.qte = qte;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	
	
	

}
