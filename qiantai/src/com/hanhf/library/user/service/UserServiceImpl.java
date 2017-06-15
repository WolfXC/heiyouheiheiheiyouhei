package com.hanhf.library.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hanhf.library.user.bean.User;
import com.hanhf.library.user.dao.UserDao;

// 服务，用于注解业务逻辑层
@Service
public class UserServiceImpl implements UserService {
	// 依赖资源
	@Resource
	private UserDao userDao;

	@Override
	public void addUser(User user) {
		userDao.add(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Override
	public void deleteUser(User user) {
		userDao.delete(user);
	}

	@Override
	public User findUserById(Integer id) {
		return userDao.findById(id);
	}

	@Override
	public List<User> findAllUser() {
		return userDao.findAll();
	}

	// getter & setter

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
