package com.cg.dao;

import java.util.List;

import com.cg.entity.User;



public interface UserDAO {

	List<User> getAllUsers();

	User getUserById(String userId);

	User addNewUser(User user);
	
	User  deleteUser(String userId) ;

	Object getAllUserSettings(String userId);

	String getUserSetting(String userId, String key);

	String addUserSetting(String userId, String key, String value);
}