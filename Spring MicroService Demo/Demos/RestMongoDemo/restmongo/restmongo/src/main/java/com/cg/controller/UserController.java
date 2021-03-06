package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.User;
import com.cg.exception.UserNotFoundException;
import com.cg.service.UserService;



@RestController
@RequestMapping(value = "/")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	
	@Autowired
	private  UserService userService;

	

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User addNewUsers(@Valid @RequestBody User user) {
		LOG.info("Saving user Details .");
		return userService.addNewUser(user);
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public User deleteUser(@PathVariable String userId) {
		LOG.info("Deleting user.");
		return userService.deleteUser(userId);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		LOG.info("Getting all users.");
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable String userId) {
		LOG.info("Getting user with ID: {}.", userId);
	    User  user = userService.getUserById(userId);
	    if( user == null)
	    {
	    	throw new UserNotFoundException(" User Not Found ");
	    }
	    
	    return user;
	}

	

	@RequestMapping(value = "/settings/{userId}", method = RequestMethod.GET)
	public Object getAllUserSettings(@PathVariable String userId) {
		User user = userService.getUserById(userId);
		if (user != null) {
			return userService.getAllUserSettings(userId);
		} else {
			return "User not found.";
		}
	}

	

	@RequestMapping(value = "/settings/{userId}/{key}", method = RequestMethod.GET)
	public String getUserSetting(@PathVariable String userId, @PathVariable String key) {
		return userService.getUserSetting(userId, key);
	}

	@RequestMapping(value = "/settings/{userId}/{key}/{value}", method = RequestMethod.PUT)
	public String addUserSetting(@PathVariable String userId, @PathVariable String key, @PathVariable String value) {
		User user = userService.getUserById(userId);
		if (user != null) {
			user.getUserSettings().put(key, value);
			userService.addNewUser(user);
			return "Key added";
		} else {
			return "User not found.";
		}
	}
}