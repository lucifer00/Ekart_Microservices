package com.ekart.cart.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ekart.cart.entity.Cart;
import com.ekart.cart.entity.CartId;

public interface CartRepository extends JpaRepository<Cart, CartId> {
	public List<Cart> findByCartIdUserId(String user_id);
}