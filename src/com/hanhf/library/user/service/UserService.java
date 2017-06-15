package com.hanhf.library.user.service;

import java.util.List;

import com.hanhf.library.user.bean.User;

public interface UserService {
	void addUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

	User findUserById(Integer id);

	List<User> findAllUser();

	User findUserByNameAndPwd(String name);

	User findUserNameAndPwd(String name, String pwd);
}
