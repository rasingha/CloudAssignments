package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.dao.UserDAO;
import com.cg.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User getUserById(String userId) {

		return userDao.getUserById(userId);
	}

	@Override
	public User addNewUser(User user) {

		return userDao.addNewUser(user);
	}

	@Override
	public Object getAllUserSettings(String userId) {
		return userDao.getAllUserSettings(userId);
	}

	@Override
	public String getUserSetting(String userId, String key) {

		return userDao.getUserSetting(userId, key);
	}

	@Override
	public String addUserSetting(String userId, String key, String value) {

		return userDao.addUserSetting(userId, key, value);
	}

	@Override
	public User deleteUser(String userId) {

		return userDao.deleteUser(userId);
	}
}
