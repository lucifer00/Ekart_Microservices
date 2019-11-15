package com.ekart.cart.dto;

import java.util.List;

public class CartDto {
	private List<CartDetailsDto> cartdetails;
	private double totalPrice;
	private int totalDeliveryCharge;
	private double grandTotal;
	public List<CartDetailsDto> getCartdetails() {
		return cartdetails;
	}
	public void setCartdetails(List<CartDetailsDto> cartdetails) {
		this.cartdetails = cartdetails;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getTotalDeliveryCharge() {
		return totalDeliveryCharge;
	}
	public void setTotalDeliveryCharge(int totalDeliveryCharge) {
		this.totalDeliveryCharge = totalDeliveryCharge;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
}
