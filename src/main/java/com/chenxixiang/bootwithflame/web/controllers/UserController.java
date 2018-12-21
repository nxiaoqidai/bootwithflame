package com.chenxixiang.bootwithflame.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenxixiang.bootwithflame.dao.pojo.User;
import com.chenxixiang.bootwithflame.service.interfaces.UserService;
import com.chenxixiang.bootwithflame.web.common.CommonConstant;
import com.chenxixiang.bootwithflame.web.common.WebResult;

import io.swagger.annotations.ApiOperation;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@ApiOperation(value = "统计用户数量", notes = "统计用户数量")
	@RequestMapping(method = RequestMethod.GET, value = "/countAllUser")
	public String countUser() {
		return userService.showUsers() + "";
	}

	@ApiOperation(value = "获取所有用户信息", notes = "获取所有用户信息")
	@RequestMapping(method = RequestMethod.GET, value = "/showAllUser")
	public String showAllUser() {
		return userService.showAll();
	}

	@ApiOperation(value = "获取用户信息", notes = "获取所有用户信息")
	@RequestMapping(method = RequestMethod.GET, value = "/select")
	public @ResponseBody WebResult selectUser(@ModelAttribute User user) {
		List<User> results = userService.selectUser(user);
		WebResult webResult = new WebResult();
		webResult.setData(results);
		return webResult;
	}

	@ApiOperation(value = "新增单个用户", notes = "新增单个用户")
	@RequestMapping(method = RequestMethod.POST, value = "/insert")
	public @ResponseBody String insert(@ModelAttribute User user) {
		if (userService.insert(user) == 1) {
			return CommonConstant.SUCCESS;
		} else {
			return CommonConstant.FAILED;
		}
	}

	@ApiOperation(value = "删除单个用户", notes = "删除单个用户")
	@RequestMapping(method = RequestMethod.POST, value = "/delete")
	public @ResponseBody String delete(@ModelAttribute User user) {
		if (userService.delete(user) == 1) {
			return CommonConstant.SUCCESS;
		} else {
			return CommonConstant.FAILED;
		}
	}
}
