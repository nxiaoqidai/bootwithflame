package com.chenxixiang.bootwithflame.service.impls;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.chenxixiang.bootwithflame.dao.impl.UserDao;
import com.chenxixiang.bootwithflame.dao.pojo.User;
import com.chenxixiang.bootwithflame.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao dao;

	private static final Logger Logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public int showUsers() {
		List<User> list = dao.selectAll();
		System.out.println(list.size());
		Logger.info(JSONUtils.toJSONString(list.get(0).getName()));
		return list.size();
	}

	@Override
	public String showAll() {
		List<User> list = dao.selectAll();
		// return JSON;
		return JSON.toJSONString(list);
	}

	@Override
	public List<User> selectUser(User user) {

		return dao.select(user);
	}

	@Override
	public int insert(User user) {

		return dao.insert(user);
	}

	@Override
	public int delete(User user) {

		return dao.delete(user);
	}

}
