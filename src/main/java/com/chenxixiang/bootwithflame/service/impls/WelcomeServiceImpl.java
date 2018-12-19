package com.chenxixiang.bootwithflame.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenxixiang.bootwithflame.dao.impl.UserDao;
import com.chenxixiang.bootwithflame.service.interfaces.WelcomeService;

@Service
public class WelcomeServiceImpl implements WelcomeService {
	@Autowired
	UserDao dao;

	public String foo() {
		return "FOO method ^-^";
	}

}
