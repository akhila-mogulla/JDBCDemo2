package com.dnb.JDBCDemo.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dnb.JDBCDemo.exceptions.IdNotFoundException;
import com.dnb.JDBCDemo.exceptions.InvalidContactNumberException;

@ControllerAdvice
public class AppAdvice {
	
	@ExceptionHandler(IdNotFoundException.class)//will act as a global exception handler
	public ResponseEntity<?> invalidAccoutIdExceptionHandler(IdNotFoundException e){
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", e.getMessage());
		map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
		ResponseEntity<?> responseEntity = new ResponseEntity(map,HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	@ExceptionHandler(InvalidContactNumberException.class)//will act as a global exception handler
	public ResponseEntity<?> invalidContactNumberExceptionHandler(InvalidContactNumberException e){
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("message", e.getMessage());
		map1.put("HttpStatus", HttpStatus.NOT_FOUND+"");
		ResponseEntity<?> responseEntity = new ResponseEntity(map1,HttpStatus.NOT_FOUND);
		return responseEntity;
	}
}
