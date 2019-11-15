package com.ekart.account.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.account.dto.UserDto;
import com.ekart.account.exception.EmailIdInUseException;
import com.ekart.account.service.AccountService;

@RestController
@CrossOrigin
public class AccountController {
	@Autowired
	AccountService service;
	@PostMapping(value = "/account/signup",consumes =MediaType.APPLICATION_JSON_VALUE)
	public String Register(@RequestBody UserDto userDto) throws EmailIdInUseException {
		service.createUser(userDto);
		return userDto.getUserId();
	}
	@PostMapping(value = "/account/login",consumes =MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin
	public boolean Login(@RequestBody UserDto userDto){
		return service.login(userDto);
	}
	@GetMapping("/account/{userId}")
	public UserDto getProfile(@PathVariable String userId) {
		return service.getProfile(userId);
	}
	@PostMapping("/account/{userId}/update")
	public boolean updateProfile(@RequestBody UserDto userDto,@PathVariable String userId) {
		System.out.println(userDto.toString());
		return service.updateProfile(userDto, userId);
	}
}
