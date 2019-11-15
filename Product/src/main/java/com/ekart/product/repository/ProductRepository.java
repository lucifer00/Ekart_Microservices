package com.ekart.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ekart.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product,String> {

}
