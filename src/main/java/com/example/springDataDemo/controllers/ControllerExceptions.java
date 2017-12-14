package com.example.springDataDemo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import com.example.springDataDemo.controllers.exceptionHandler.BaseExceptionHandler;
import com.example.springDataDemo.controllers.exceptionHandler.UserNotFoundException;

@ControllerAdvice
public class ControllerExceptions extends BaseExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(ControllerExceptions.class);

	public ControllerExceptions() {
		super(logger);
		registerMapping(UserNotFoundException.class, "USER_NOT_FOUND", "User not found", HttpStatus.NOT_FOUND);
	}

}
