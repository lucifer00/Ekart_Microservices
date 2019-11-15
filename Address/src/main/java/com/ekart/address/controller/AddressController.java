package com.ekart.address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.address.dto.AddressDto;
import com.ekart.address.service.AddressService;


@RestController
@CrossOrigin
public class AddressController {
	@Autowired
	AddressService service;
	@PostMapping("/address/{userId}/address/add")
	public String addAddress(@PathVariable String userId,@RequestBody AddressDto addressDto) {
		return service.addAddress(userId,addressDto);
	}
	@GetMapping("/address/{userId}/address")
	public List<AddressDto> getAllAddresses(@PathVariable String userId){
		return service.getAllAddresses(userId);
	}
	@PostMapping("/address/{userId}/address/{addressId}/modify")
	public String modifyAddress(@PathVariable String userId,@PathVariable String addressId,@RequestBody AddressDto addressDto) {
		return service.modifyAddress(userId,addressId,addressDto);
	}
	@GetMapping("/address/{userId}/address/{addressId}/delete")
	public void deleteAddress(@PathVariable String userId,@PathVariable String addressId) {
		System.out.println(userId+" "+addressId);
		service.deleteAddress(userId,addressId);
	}
}