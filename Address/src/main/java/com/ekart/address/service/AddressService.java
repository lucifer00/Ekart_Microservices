package com.ekart.address.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.address.dto.AddressDto;
import com.ekart.address.entity.Address;
import com.ekart.address.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired 
	AddressRepository addressRepository;
	public String addAddress(String userId,AddressDto addressDto) {
		Address lastEntry=addressRepository.findFirstByOrderByAddressIdDesc();
		Address address=new Address();
		address.setAddress(addressDto.getAddress());
		if(lastEntry==null)
			address.setAddressId("A1");
		else
			address.setAddressId("A"+
					(Character.getNumericValue(addressRepository.findFirstByOrderByAddressIdDesc().
							getAddressId().charAt(1))+1));
		address.setCity(addressDto.getCity());
		address.setPhonenumber(addressDto.getPhonenumber());
		address.setPincode(addressDto.getPincode());
		address.setState(addressDto.getState());
		address.setUserId(userId);
		return addressRepository.saveAndFlush(address).getAddressId();
	}
	public List<AddressDto> getAllAddressesOfUser(String userId){
		List<Address> addresses=addressRepository.findByUserId(userId);
		List<AddressDto> toRet=new ArrayList<>();
		for(Address address:addresses) {
			AddressDto addressDto=new AddressDto();
			addressDto.setAddress(address.getAddress());
			addressDto.setAddressId(address.getAddressId());
			addressDto.setCity(address.getCity());
			addressDto.setPhonenumber(address.getPhonenumber());
			addressDto.setPincode(address.getPincode());
			addressDto.setState(address.getState());
			toRet.add(addressDto);
		}
		return toRet;
	}
	public String modifyAddressOfUser(String userId,String addressId,AddressDto addressDto) {
		Address address=new Address();
		address.setAddress(addressDto.getAddress());
		address.setAddressId(addressId);
		address.setCity(addressDto.getCity());
		address.setPhonenumber(addressDto.getPhonenumber());
		address.setPincode(addressDto.getPincode());
		address.setState(addressDto.getState());
		address.setUserId(userId);
		return addressRepository.saveAndFlush(address).getAddressId();
	}
	public void deleteAddressOfUser(String userId,String addressId) {
		addressRepository.deleteById(addressId);
	}
}
