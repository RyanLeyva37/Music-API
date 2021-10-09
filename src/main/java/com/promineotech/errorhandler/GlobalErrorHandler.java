package com.promineotech.errorhandler;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice

public class GlobalErrorHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Map<String, String> handleNoSuchElementException(NoSuchElementException e, WebRequest webRequest) {
		
		Map<String, String> error = new HashMap<>();
		
		error.put("message", e.toString());
		error.put("status code", HttpStatus.NOT_FOUND.toString());
		error.put("reason", "There is no list of artists present in the database");
		
		return error;
	}
}
