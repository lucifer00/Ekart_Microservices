package com.ekart.cart.service;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ekart.cart.controller.CartFeign;
import com.ekart.cart.dto.ProductDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;

@Service
public class CartHystrixService {
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	CartFeign cartFeign;
	
	@HystrixCommand
	public Future<ProductDto> getSpecificProduct(String productId) {
		return new AsyncResult<ProductDto>() {
			@Override
			public ProductDto invoke() {
				return cartFeign.getSpecificProduct(productId);
			}
		};
		
	}
}
