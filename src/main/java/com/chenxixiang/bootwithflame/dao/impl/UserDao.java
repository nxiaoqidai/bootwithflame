package com.chenxixiang.bootwithflame.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chenxixiang.bootwithflame.dao.interfaces.UserMapper;
import com.chenxixiang.bootwithflame.dao.pojo.User;

@Repository
public class UserDao {
	@Autowired
	UserMapper mapper;

	public List<User> selectAll() {
		return mapper.selectAll();
	}

}
