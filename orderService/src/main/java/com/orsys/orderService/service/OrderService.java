package com.orsys.orderService.service;

import java.util.List;

import com.orsys.orderService.dto.CreateOrderRequest;
import com.orsys.orderService.models.Order;

public interface OrderService {
	
	List<Order> getOrders();
	
	Order createOrder(CreateOrderRequest req);
	
	

}
