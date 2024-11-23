package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	private Logger logger = LogManager.getLogger(OrderService.class);

	private List<Order> orders = new ArrayList<>();

	public Order addOrder(Order order) {
		logger.info("OrderService : Add Order started ...");
		logger.info("add order request {}", Mapper.mapObjectToJson(order));
		order.setOrderPlacedDate(new Date());
		order.setTransactionId(UUID.randomUUID().toString());
		orders.add(order);
		logger.info("add Ended order response {}", Mapper.mapObjectToJson(order));
		return order;
	}

	public List<Order> getOrders() {
		logger.info("OrderService : getOrders started ...");
		logger.info("add Ended getOrders response ", Mapper.mapObjectToJson(orders));
		return orders;

	}

	public Order getOrder(int id) {
		logger.info("OrderService : getOrder started ...");

		Order order = orders.stream().filter(o -> o.getId() == id).findAny()
				.orElseThrow(() -> new RuntimeException("Order not found " + id));
		logger.info("add Ended getOrders response {}", Mapper.mapObjectToJson(order));
		return order;
	}

}
