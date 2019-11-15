package com.ekart.account.dto;

import com.ekart.account.entity.User;

public class UserDto {
	private String userId;
	private String email;
	private String name;
	private String password;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User createUser(UserDto dto) {
		User user=new User();
		user.setEmail(dto.getEmail());
		user.setName(dto.getName());
		user.setPassword(dto.getPassword());
		user.setUserId(dto.getUserId());
		return user;
	}
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", email=" + email + ", name=" + name + ", password=" + password + "]";
	}
}
