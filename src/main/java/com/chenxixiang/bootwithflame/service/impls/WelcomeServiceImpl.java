package com.chenxixiang.bootwithflame.service.impls;

import org.springframework.stereotype.Service;

import com.chenxixiang.bootwithflame.service.interfaces.WelcomeService;

@Service
public class WelcomeServiceImpl implements WelcomeService {

	public String foo() {
		return "FOO method ^-^";
	}

}
