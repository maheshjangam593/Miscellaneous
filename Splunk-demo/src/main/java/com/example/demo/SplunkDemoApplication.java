package com.example.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.Mapper;
import com.example.demo.service.Order;
import com.example.demo.service.OrderService;

@RestController
@SpringBootApplication
public class SplunkDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplunkDemoApplication.class, args);
	}

	private Logger logger = LogManager.getLogger(SplunkDemoApplication.class);

	@Autowired
	private OrderService service;
	/*
	 * @Autowired private JobService jobService;
	 */

	@PostMapping("/orders")
	public Order addOrder(Order order) {
		logger.info("Controller  : addOrder  request {}", Mapper.mapObjectToJson(order));
		Order order1 = service.addOrder(order);
		logger.info("Controller  : addOrder  response from service {}", Mapper.mapObjectToJson(order));
		return order1;
	}

	@GetMapping("/orders")
	public List<Order> getOrders() {
		logger.info("Controller  : getOrders  response from service {}", Mapper.mapObjectToJson(service.getOrders()));
		return service.getOrders();
	}

	@GetMapping("/orders/{id}")
	public Order getById(@PathVariable int id) {
		logger.info("Controller  : getById  response from service id  {}",
				Mapper.mapObjectToJson(service.getOrder(id)));
		return service.getOrder(id);
	}

	/*
	 * @PostMapping("/job") public JobStatus processOrder(@RequestBody Order order)
	 * { logger.info("order contrller : processorder request {}",
	 * Mapper.mapObjectToJson(order));
	 * 
	 * JobStatus job=jobService.process(order); logger.info("current job satust {}",
	 * job); return job; }
	 */

}
