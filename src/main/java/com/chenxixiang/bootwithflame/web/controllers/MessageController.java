package com.chenxixiang.bootwithflame.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chenxixiang.bootwithflame.mongodb.domain.Message;
import com.chenxixiang.bootwithflame.otherdto.MessageSessionsInfo;
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
	public @ResponseBody WebResult<?> create(@RequestBody Message message) {
		if (messageService.insert(message) == 1) {
			return WebResultUtil.success();
		} else {
			return WebResultUtil.error(ExceptionEnum.UNKNOW_Exception);
		}

	}

	@ApiOperation(value = "查看用户全套消息", notes = "查看用户全套消息")
	@RequestMapping(method = RequestMethod.GET, value = "/select-by-user")
	public @ResponseBody WebResult<List<Message>> selectByUser(@ModelAttribute Message message) {
		if (!StringUtils.hasText(message.getUser1Id())) {
			throw new MyException(ExceptionEnum.PARAM_NULL);
		}
		return WebResultUtil.success(messageService.find(message));
	}

	@ApiOperation(value = "查看某会话全套消息", notes = "查看某会话全套消息")
	@RequestMapping(method = RequestMethod.GET, value = "/select-by-session")
	public @ResponseBody WebResult<List<Message>> selectBySession(@ModelAttribute Message message) {
		if (!StringUtils.hasText(message.getSessionId())) {
			throw new MyException(ExceptionEnum.PARAM_NULL);
		}
		return WebResultUtil.success(messageService.find(message));
	}

	@ApiOperation(value = "查看用户session", notes = "查看用户历史会话id")
	@RequestMapping(method = RequestMethod.GET, value = "/userSessions")
	public @ResponseBody WebResult<List<MessageSessionsInfo>> getUser1Sessions(
			@RequestParam(value = "用户id") String User1Id,
			@RequestParam(value = "会话结束时间范围(起)", required = false) Long startTime,
			@RequestParam(value = "会话结束时间范围(止)", required = false) Long closeTime) {
		if (StringUtils.isEmpty(User1Id)) {
			throw new MyException(ExceptionEnum.PARAM_NULL);
		}
		List<MessageSessionsInfo> result = messageService.getSessionInfo(User1Id, startTime,
				closeTime);

		return WebResultUtil.success(result);
	}

}
