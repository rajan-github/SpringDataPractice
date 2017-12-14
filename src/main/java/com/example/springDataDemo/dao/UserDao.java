package com.example.springDataDemo.dao;

import com.example.springDataDemo.model.User;

public interface UserDao extends BaseDao<User, Long> {
	public User findByLastName(String lastName);

	public User findByFirstName(String firstName);
}
