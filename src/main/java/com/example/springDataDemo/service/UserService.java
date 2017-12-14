package com.example.springDataDemo.service;

import com.example.springDataDemo.dao.UserDao;
import com.example.springDataDemo.model.User;

public interface UserService extends BaseService<User, Long> {
	public UserDao getDao();

	public User findByLastName(String lastName);

	public User findByFirstName(String firstName);

}
