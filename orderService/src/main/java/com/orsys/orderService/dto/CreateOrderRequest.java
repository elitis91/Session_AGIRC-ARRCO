package com.orsys.orderService.dto;

import java.util.UUID;

public class CreateOrderRequest {
	
	private UUID idBook;
	private Integer qte;
	public UUID getIdBook() {
		return idBook;
	}
	public void setIdBook(UUID idBook) {
		this.idBook = idBook;
	}
	public Integer getQte() {
		return qte;
	}
	public void setQte(Integer qte) {
		this.qte = qte;
	}
	
	

}
