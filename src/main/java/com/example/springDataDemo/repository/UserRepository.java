package com.example.springDataDemo.repository;

import com.example.springDataDemo.model.User;

public interface UserRepository extends BaseRepository<User, Long> {
	public User findByLastName(String lastName);

	public User findByFirstName(String firstName);
}
