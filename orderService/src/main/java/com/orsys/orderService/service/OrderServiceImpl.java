package com.orsys.orderService.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.orsys.orderService.dao.OrderDao;
import com.orsys.orderService.dto.BookDto;
import com.orsys.orderService.dto.CreateOrderRequest;
import com.orsys.orderService.models.Order;
import com.orsys.orderService.models.OrderStatus;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	OrderDao orderDao;

	@Override
	public List<Order> getOrders() {
		return orderDao.findAll();
	}

	@Override
	public Order createOrder(CreateOrderRequest req) {
		System.out.println("------ START ------");
		UUID idBook = req.getIdBook();
		Integer qte =req.getQte();
		
		System.out.println("idBook : " + idBook);
		System.out.println("qty  : " + qte);
		
		BookDto book = null;
		try {
			book = restTemplate.getForObject(
					"http://localhost:8085/api/v1/books/" + idBook, 
					BookDto.class);
			System.out.println("retrieved book  : " +book);
			
		} catch (HttpClientErrorException.NotFound e) {
			// TODO: handle exception
			System.out.println("Erreur lors de l'appel ");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erreur lors de l'appel ");
			e.printStackTrace();
			throw e;
		}
		
		Order order = new Order();
		order.setIdBook(idBook);
		order.setQte(qte);
		
		if (book==null) {
			order.setStatus(OrderStatus.BOOK_NOT_FOUND);
		} else if (Boolean.FALSE.equals(book.getPublish())) {
			order.setStatus(OrderStatus.BOOK_NOT_AVAILABLE);
		} else {
			order.setStatus(OrderStatus.CREATED);
			order.setTitle(book.getTitle());
		}
		
		return orderDao.save(order);
	}

}
