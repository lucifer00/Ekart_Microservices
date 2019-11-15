package com.ekart.account.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ekart.account.entity.Error;
import com.ekart.account.exception.EmailIdInUseException;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	@ExceptionHandler(EmailIdInUseException.class)
	public ResponseEntity<Error> exceptionHandler2(EmailIdInUseException ex) {
		Error error=new Error();
		error.setErrorCode(HttpStatus.BAD_GATEWAY.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
}
