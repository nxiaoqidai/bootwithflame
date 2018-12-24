package com.chenxixiang.bootwithflame.service.impls;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.support.json.JSONUtils;
import com.chenxixiang.bootwithflame.dao.impl.UserDao;
import com.chenxixiang.bootwithflame.dao.pojo.User;
import com.chenxixiang.bootwithflame.service.interfaces.UserService;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao dao;

	private static Logger LOGGER = ((LoggerContext) LoggerFactory.getILoggerFactory())
			.getLogger(UserServiceImpl.class);

	@Override
	public int showUsers() {
		List<User> list = dao.selectAll();
		LOGGER.info(JSONUtils.toJSONString(list.get(0).getName()));
		return list.size();
	}

	@Override
	public List<User> showAll() {
		List<User> list = dao.selectAll();
		return list;
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
