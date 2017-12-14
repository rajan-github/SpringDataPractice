package com.example.springDataDemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springDataDemo.dao.UserDao;
import com.example.springDataDemo.model.User;
import com.example.springDataDemo.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findByLastName(String lastName) {
		return getDao().findByLastName(lastName);
	}

	@Override
	public User findByFirstName(String firstName) {
		return userDao.findByFirstName(firstName);
	}

	@Override
	public UserDao getDao() {
		return userDao;
	}

}
