package com.mouritech.onlinefooddeliveryapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OrderNotFound extends RuntimeException {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1969645206056328895L;

	public OrderNotFound(String msg) {
		
		super(msg);
	}
}