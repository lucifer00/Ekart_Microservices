package com.ekart.cart.dto;

public class CartDetailsDto {
	private String displayName;
	private String category;
	private double price;
	private int deliveryCharge;
	private int quantity;
	private double total;
	private String product_id;
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(int deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
