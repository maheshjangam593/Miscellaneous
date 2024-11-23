package com.example.demo.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class JobService {

	
	Logger logger = LogManager.getLogger(JobService.class);
	
	/*
	 * public JobStatus process(Order order) {
	 * logger.info("Jobservice : Process request {} ",
	 * Mapper.mapObjectToJson(order)); if(otherApiResults()) { return
	 * JobStatus.SUCCESS; } else { return JobStatus.FAILED;
	 * 
	 * } }
	 * 
	 * private boolean otherApiResults() { // TODO Auto-generated method stub return
	 * new Random().nextBoolean(); }
	 */
}
