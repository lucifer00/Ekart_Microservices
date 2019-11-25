package com.ekart.cart.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ekart.cart.dto.ProductDto;

@FeignClient("ProductMS")
public interface ProductFeign {
	@RequestMapping(value="/product/products/{prodId}")
	ProductDto getSpecificProduct(@PathVariable("prodId") String prodId);
}
