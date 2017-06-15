package com.hanhf.library.type.service;

import java.util.List;

import com.hanhf.library.type.bean.Type;



public interface TypeService {
	void addType(Type Type);

	void updateType(Type Type);

	void deleteType(Type Type);

	Type findTypeById(Integer id);

	List<Type> findAllType();
	
}
