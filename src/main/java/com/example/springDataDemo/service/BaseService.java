package com.example.springDataDemo.service;

import java.io.Serializable;
import java.util.List;

import com.example.springDataDemo.dao.BaseDao;

public interface BaseService<T, ID extends Serializable> {
	public BaseDao<T, ID> getDao();

	public T save(T item);

	public void delete(T item);

	public T findOne(ID id);

	public void deleteAll();

	public List<T> findAll();
}
