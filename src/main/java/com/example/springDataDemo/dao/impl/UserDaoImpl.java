package com.example.springDataDemo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springDataDemo.dao.UserDao;
import com.example.springDataDemo.model.User;
import com.example.springDataDemo.repository.UserRepository;

@Repository(value = "userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {

	@Autowired
	private UserRepository userRepository;

	@Override
	public JpaRepository<User, Long> getRepository() {
		return userRepository;
	}

	@Override
	public User findByLastName(String lastName) {
		return userRepository.findByLastName(lastName);
	}

	@Override
	public User findByFirstName(String firstName) {
		return userRepository.findByFirstName(firstName);
	}

}
