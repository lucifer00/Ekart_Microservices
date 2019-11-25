package com.ekart.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.cart.dto.AddCartDto;
import com.ekart.cart.dto.CartDto;
import com.ekart.cart.entity.Cart;
import com.ekart.cart.entity.CartId;
import com.ekart.cart.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	CartRepository repository;
	public boolean addToKartOfUser(AddCartDto dto,String user_id) {
		Cart cart=new Cart();
		cart.setQuantity(dto.getQuantity());
		cart.setCartId(new CartId(user_id, dto.getProduct_id()));
		if(repository.save(cart)!=null)return true;
		return false;
	}
	
	public List<Cart> getKartOfUser(String user_id) {
		List<Cart> carts=repository.findByCartIdUserId(user_id);
		return carts;
	}
	public boolean updateKartOfUser(AddCartDto dto,String user_id) {
		Cart cart=new Cart();
		cart.setQuantity(dto.getQuantity());
		cart.setCartId(new CartId(user_id, dto.getProduct_id()));
		if(repository.saveAndFlush(cart)!=null)return true;
		return false;
	}
	public void updateKartDeleteOfUser(AddCartDto dto,String user_id) {
		Cart cart=new Cart();
		cart.setQuantity(dto.getQuantity());
		cart.setCartId(new CartId(user_id, dto.getProduct_id()));
		repository.delete(cart);
	}
	public int getCartCountOfUser(String userId) {
		List<Cart> carts=repository.findByCartIdUserId(userId);
		return carts.size();
	}
}
