package com.ekart.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ekart.account.entity.User;


public interface UserRepository extends JpaRepository<User,String> {
	public List<User> findByEmail(String email);
}
