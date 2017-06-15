package com.hanhf.library.user.dao;

import java.util.List;

import com.hanhf.library.user.bean.User;

public interface UserDao {
	void add(User user);

	void update(User user);

	void delete(User user);

	User findById(Integer id);

	List<User> findAll();
}
