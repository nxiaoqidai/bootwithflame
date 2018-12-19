package com.chenxixiang.bootwithflame.service.interfaces;

import java.util.List;

import com.chenxixiang.bootwithflame.dao.pojo.User;

public interface UserService {
	int showUsers();

	String showAll();

	List<User> selectUser(User user);

	int insert(User user);

	int delete(User user);
}
