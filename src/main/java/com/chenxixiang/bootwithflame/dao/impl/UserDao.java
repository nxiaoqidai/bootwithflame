package com.chenxixiang.bootwithflame.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.chenxixiang.bootwithflame.dao.interfaces.UserMapper;
import com.chenxixiang.bootwithflame.dao.pojo.User;

@Repository
public class UserDao {
	@Autowired
	UserMapper mapper;

	public List<User> selectAll() {
		return mapper.selectAll();
	}

	public List<User> select(User user) {
		return mapper.select(user);
	}

	public int insert(User user) {
		user.setId(UUID.randomUUID().toString());
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		return mapper.insert(user);
	}

	public int delete(User user) {
		if (user == null || (StringUtils.isEmpty(user.getId()) && StringUtils.isEmpty(user.getName()))) {
			return 0;
		}
		return mapper.delete(user);
	}

}
