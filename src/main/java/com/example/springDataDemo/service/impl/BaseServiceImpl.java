package com.example.springDataDemo.service.impl;

import java.io.Serializable;
import java.util.List;

import com.example.springDataDemo.service.BaseService;

public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

	@Override
	public T save(T item) {
		return getDao().save(item);
	}

	@Override
	public void delete(T item) {
		getDao().delete(item);
	}

	@Override
	public T findOne(ID id) {
		return getDao().findOne(id);
	}

	@Override
	public void deleteAll() {
		getDao().deleteAll();
	}

	@Override
	public List<T> findAll() {
		return getDao().findAll();
	}

}
