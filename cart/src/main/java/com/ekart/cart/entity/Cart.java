package com.ekart.cart.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", quantity=" + quantity + "]";
	}
	@EmbeddedId
	private CartId cartId;
	private int quantity;
	public CartId getCartId() {
		return cartId;
	}
	public void setCartId(CartId cartId) {
		this.cartId = cartId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
