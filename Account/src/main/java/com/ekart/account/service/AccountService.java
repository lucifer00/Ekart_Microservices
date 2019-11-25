package com.ekart.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.account.dto.UserDto;
import com.ekart.account.entity.User;
import com.ekart.account.exception.EmailIdInUseException;
import com.ekart.account.repository.UserRepository;

@Service
public class AccountService {
	@Autowired
	UserRepository userRepository;
	public void createUser(UserDto dto)throws EmailIdInUseException {
		User user=dto.createUser(dto);
		if(userRepository.findByEmail(user.getEmail()).size()!=0) {
			throw new EmailIdInUseException("Email id already present");
		}
		else 
			userRepository.save(user);
	}
	public boolean login(UserDto dto) {
		User user=userRepository.getOne(dto.getUserId());
		if(user.getPassword().equals(dto.getPassword()))
			return true;
		return false;
	}
	public UserDto getProfileForUserId(String userId) {
		User user=userRepository.getOne(userId);
		UserDto toRet=new UserDto();
		toRet.setEmail(user.getEmail());
		toRet.setName(user.getName());
		return toRet;
	}
	public boolean updateProfileOfUserId(UserDto userDto,String userId) {
		boolean toRet=false;
		User user=userRepository.getOne(userId);
		User newDetails=new User();
		newDetails.setEmail(userDto.getEmail());
		newDetails.setName(userDto.getName());
		newDetails.setUserId(userId);
		if(userDto.getPassword()==null)
			newDetails.setPassword(user.getPassword());
		else
			newDetails.setPassword(userDto.getPassword());
		if(userRepository.saveAndFlush(newDetails)!=null)
			toRet=true;
		return toRet;
	}
}
