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
	AccountService accountService;
	@PostMapping(value = "/account/signup",consumes =MediaType.APPLICATION_JSON_VALUE)
	public String Register(@RequestBody UserDto userDto) throws EmailIdInUseException {
		accountService.createUser(userDto);
		return userDto.getUserId();
	}
	@PostMapping(value = "/account/login",consumes =MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin
	public boolean Login(@RequestBody UserDto userDto){
		return accountService.login(userDto);
	}
	@GetMapping("/account/{userId}")
	public UserDto getProfileForUserId(@PathVariable String userId) {
		return accountService.getProfileForUserId(userId);
	}
	@PostMapping("/account/{userId}/update")
	public boolean updateProfileOfUserId(@RequestBody UserDto userDto,@PathVariable String userId) {
		return accountService.updateProfileOfUserId(userDto, userId);
	}
}
