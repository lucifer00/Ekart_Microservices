package com.ekart.cart.dto;

public class AddCartDto {
	private String product_id;
	private int quantity;
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "AddCartDto [product_id=" + product_id + ", quantity=" + quantity + "]";
	}
	
}
