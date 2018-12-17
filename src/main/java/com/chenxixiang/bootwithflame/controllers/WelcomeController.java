package com.chenxixiang.bootwithflame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chenxixiang.bootwithflame.service.interfaces.WelcomeService;

@RestController
public class WelcomeController {
	@Autowired
	WelcomeService welcomeService;

	@RequestMapping(method = RequestMethod.GET, value = "helloworld")
	public String helloWorld() {

		return welcomeService.foo() + "   hello world";
	}

	@RequestMapping(method = RequestMethod.GET, value = "countUser")
	public String countUser() {
		return welcomeService.showUsers() + "";
	}
}
