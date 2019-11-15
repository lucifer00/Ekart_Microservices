package com.ekart.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
	@Id
	private String prod_id;
	private String displayname;
	@Column(name="shortnesc")
	private String shortdesc;
	private String description;
	private String category;
	private double price;
	private int discount;
	private int deliverycharge;
	@Override
	public String toString() {
		return "Product [prod_id=" + prod_id + ", displayName=" + displayname + ", shortDesc=" + shortdesc
				+ ", description=" + description + ", category=" + category + ", price=" + price + ", discount="
				+ discount + ", deliveryCharge=" + deliverycharge + "]";
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getDisplayName() {
		return displayname;
	}
	public void setDisplayName(String displayname) {
		this.displayname = displayname;
	}
	public String getShortDesc() {
		return shortdesc;
	}
	public void setShortDesc(String shortdesc) {
		this.shortdesc = shortdesc;
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
		return deliverycharge;
	}
	public void setDeliveryCharge(int deliveryCharge) {
		this.deliverycharge = deliverycharge;
	}
}
