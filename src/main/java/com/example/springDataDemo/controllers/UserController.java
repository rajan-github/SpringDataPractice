package com.example.springDataDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springDataDemo.controllers.exceptionHandler.UserNotFoundException;
import com.example.springDataDemo.model.User;
import com.example.springDataDemo.service.UserService;

@RequestMapping(value = "/users")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<User> save(@RequestBody User user) {
		User savedUser = userService.save(user);
		return new ResponseEntity<>(savedUser, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/fetchAll", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<User>> fetchAll() {
		List<User> users = userService.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<User> findUser(@PathVariable("id") Long id) {
		User user = userService.findOne(id);
		if (user == null) {
			throw new UserNotFoundException();
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
