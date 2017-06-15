package com.hanhf.library.type.dao;

import java.util.List;

import com.hanhf.library.type.bean.Type;


public interface TypeDao {
	void add(Type type);

	void update(Type type);

	void delete(Type type);

	Type findById(Integer id);

	List<Type> findAll();
}