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
	AddressService addressService;
	@PostMapping("/address/{userId}/address/add")
	public String addAddress(@PathVariable String userId,@RequestBody AddressDto addressDto) {
		return addressService.addAddress(userId,addressDto);
	}
	@GetMapping("/address/{userId}/address")
	public List<AddressDto> getAllAddressesOfUser(@PathVariable String userId){
		return addressService.getAllAddressesOfUser(userId);
	}
	@PostMapping("/address/{userId}/address/{addressId}/modify")
	public String modifyAddressOfUser(@PathVariable String userId,@PathVariable String addressId,@RequestBody AddressDto addressDto) {
		return addressService.modifyAddressOfUser(userId,addressId,addressDto);
	}
	@GetMapping("/address/{userId}/address/{addressId}/delete")
	public void deleteAddressOfUser(@PathVariable String userId,@PathVariable String addressId) {
		addressService.deleteAddressOfUser(userId,addressId);
	}
}
