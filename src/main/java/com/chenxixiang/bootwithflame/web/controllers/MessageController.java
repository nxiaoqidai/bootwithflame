package com.chenxixiang.bootwithflame.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chenxixiang.bootwithflame.mongodb.domain.Message;
import com.chenxixiang.bootwithflame.service.interfaces.MessageService;
import com.chenxixiang.bootwithflame.web.common.CommonConstant;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/message")
public class MessageController {
	@Autowired
	MessageService messageService;

	@ApiOperation(value = "添加消息", notes = "添加消息")
	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public @ResponseBody String create(@ModelAttribute Message message) {
		if (messageService.insert(message) == 1) {
			return CommonConstant.SUCCESS;
		} else {
			return CommonConstant.FAILED;
		}

	}

	@ApiOperation(value = "查看消息", notes = "查看消息")
	@RequestMapping(method = RequestMethod.GET, value = "/select")
	public @ResponseBody List<Message> select(@ModelAttribute Message message) {
		return messageService.find(message);
	}

}
