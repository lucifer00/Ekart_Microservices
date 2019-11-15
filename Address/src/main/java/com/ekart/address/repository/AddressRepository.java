package com.ekart.address.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ekart.address.entity.Address;

public interface AddressRepository extends JpaRepository<Address, String> {
	public List<Address> findByUserId(String userId);
	public Address findFirstByOrderByAddressIdDesc();
}
