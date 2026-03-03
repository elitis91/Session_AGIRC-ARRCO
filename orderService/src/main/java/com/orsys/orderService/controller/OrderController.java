package com.orsys.orderService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orsys.orderService.dto.CreateOrderRequest;
import com.orsys.orderService.models.Order;
import com.orsys.orderService.service.OrderService;

@RestController
@RequestMapping(path = "/api/v1/orders", produces = "application/json")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping(path = "")
	ResponseEntity<List<Order>> getOrders(){
		try {
			return new ResponseEntity<List<Order>>(
					orderService.getOrders(),
					HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "")
	ResponseEntity<Order> createOrder(@RequestBody CreateOrderRequest req){
		try {
			return new ResponseEntity<Order>(
					orderService.createOrder(req),
					HttpStatus.CREATED
					);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
