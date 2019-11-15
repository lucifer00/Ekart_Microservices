package com.ekart.product.dto;

public class ProductDto {
	private String prod_id;
	private String displayName;
	private String shortDesc;
	private String description;
	private String category;
	private double price;
	private int discount;
	private int deliveryCharge;
	@Override
	public String toString() {
		return "Product [prod_id=" + prod_id + ", displayName=" + displayName + ", shortDesc=" + shortDesc
				+ ", description=" + description + ", category=" + category + ", price=" + price + ", discount="
				+ discount + ", deliveryCharge=" + deliveryCharge + "]";
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(int deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
}
