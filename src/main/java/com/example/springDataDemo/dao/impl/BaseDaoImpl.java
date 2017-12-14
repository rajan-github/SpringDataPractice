package com.example.springDataDemo.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.example.springDataDemo.dao.BaseDao;

public abstract class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID> {

	@Override
	public T save(T item) {
		return getRepository().save(item);
	}

	@Override
	public void delete(T item) {
		getRepository().delete(item);
	}

	@Override
	public T findOne(ID id) {
		return getRepository().findOne(id);
	}

	@Override
	public void deleteAll() {
		getRepository().deleteAll();
	}

	@Override
	public List<T> findAll() {
		return getRepository().findAll();
	}

}
