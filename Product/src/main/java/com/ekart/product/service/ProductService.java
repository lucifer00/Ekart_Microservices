package com.ekart.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.product.dto.ProductDto;
import com.ekart.product.entity.Product;
import com.ekart.product.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository repository;
	public List<ProductDto> getAllProducts() {
		List<ProductDto> productDtos=new ArrayList<ProductDto>();
		List<Product> products=repository.findAll();
		for(Product product:products) {
			ProductDto dto=new ProductDto();
			dto.setProd_id(product.getProd_id());
			dto.setCategory(product.getCategory());
			dto.setDeliveryCharge(product.getDeliveryCharge());
			dto.setDescription(product.getDescription());
			dto.setDiscount(product.getDiscount());
			dto.setDisplayName(product.getDisplayName());
			dto.setPrice(product.getPrice());
			dto.setShortDesc(product.getShortDesc());
			productDtos.add(dto);
		}
		return productDtos;
	}
	public ProductDto getSpecificProduct(String prodId) {
		Product product=repository.getOne(prodId);
		ProductDto dto=new ProductDto();
		dto.setProd_id(product.getProd_id());
		dto.setCategory(product.getCategory());
		dto.setDeliveryCharge(product.getDeliveryCharge());
		dto.setDescription(product.getDescription());
		dto.setDiscount(product.getDiscount());
		dto.setDisplayName(product.getDisplayName());
		dto.setPrice(product.getPrice());
		dto.setShortDesc(product.getShortDesc());
		return dto;
	}
}