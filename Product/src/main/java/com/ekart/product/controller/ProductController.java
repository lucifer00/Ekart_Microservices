package com.ekart.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.product.dto.ProductDto;
import com.ekart.product.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {
	@Autowired
	ProductService service;
	@GetMapping("/product/products")
	public List<ProductDto> allProducts() {
		return service.getAllProducts();
	}
	@GetMapping("/product/products/{prodId}")
	public ProductDto getSpecificProduct(@PathVariable String prodId) {
		return service.getSpecificProduct(prodId);
	}
}
