package com.example.springDataDemo.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseDao<T, ID extends Serializable> {
	public JpaRepository<T, ID> getRepository();

	public T save(T item);

	public void delete(T item);

	public T findOne(ID id);

	public void deleteAll();

	public List<T> findAll();
}
