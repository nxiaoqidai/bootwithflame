package com.chenxixiang.bootwithflame.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chenxixiang.bootwithflame.elasticsearch.repository.impl.ProductTypeRepositoryImpl;
import com.chenxixiang.bootwithflame.service.interfaces.WelcomeService;
import com.chenxixiang.bootwithflame.web.common.WebResult;
import com.chenxixiang.bootwithflame.web.common.WebResultUtil;

import io.swagger.annotations.Api;

@RestController
@Api(value = "各种功能测试入口")
public class WelcomeController {
	@Autowired
	WelcomeService welcomeService;
	@Autowired
	ProductTypeRepositoryImpl repository;

	@RequestMapping(method = RequestMethod.GET, value = "testPutInRedis")
	public WebResult<String> testRedis() {
		String result = welcomeService.foo();
		return WebResultUtil.success(result);
	}

	@RequestMapping(method = RequestMethod.GET, value = "helloworld")
	public WebResult<String> helloWorld() {

		return WebResultUtil.success("Successs");

	}

}
