package com.ekart.cart.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CartId implements Serializable {
	private String userId;
	private String product_id;
	public CartId() {
		
	}
	public CartId(String user_id,String product_id) {
		this.userId=user_id;
		this.product_id=product_id;
	}
	@Override
	public String toString() {
		return "CartId [user_id=" + userId + ", product_id=" + product_id + "]";
	}
	public String getUser_id() {
		return userId;
	}
	public void setUser_id(String user_id) {
		this.userId = user_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
}
