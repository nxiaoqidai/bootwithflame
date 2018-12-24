package com.chenxixiang.bootwithflame.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chenxixiang.bootwithflame.mongodb.domain.Message;
import com.chenxixiang.bootwithflame.service.interfaces.MessageService;
import com.chenxixiang.bootwithflame.web.common.ExceptionEnum;
import com.chenxixiang.bootwithflame.web.common.MyException;
import com.chenxixiang.bootwithflame.web.common.WebResult;
import com.chenxixiang.bootwithflame.web.common.WebResultUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/message")
public class MessageController {
	@Autowired
	MessageService messageService;

	@ApiOperation(value = "添加消息", notes = "添加消息")
	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public @ResponseBody WebResult<?> create(@ModelAttribute Message message) {
		if (messageService.insert(message) == 1) {
			return WebResultUtil.success();
		} else {
			return WebResultUtil.error(ExceptionEnum.UNKNOW_Exception);
		}

	}

	@ApiOperation(value = "查看全套消息", notes = "查看全套消息")
	@RequestMapping(method = RequestMethod.GET, value = "/select")
	public @ResponseBody WebResult<List<Message>> select(@ModelAttribute Message message) {
		if (message.getUser1Id() == null) {
			throw new MyException(ExceptionEnum.PARAM_NULL);
		}
		return WebResultUtil.success(messageService.find(message));
	}

	@ApiOperation(value = "查看用户session", notes = "查看用户历史会话id")
	@RequestMapping(method = RequestMethod.GET, value = "/user1Sessions")
	public @ResponseBody WebResult<List<Message>> getUser1Sessions(
			@RequestParam(value = "用户id") String User1Id,
			@RequestParam(value = "会话结束时间范围(起)", required = false) long startTime,
			@RequestParam(value = "会话结束时间范围(止)", required = false) long closeTime) {
		if (StringUtils.isEmpty(User1Id)) {
			throw new MyException(ExceptionEnum.PARAM_NULL);
		}
		return null;
	}

}
