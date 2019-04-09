package com.chenxixiang.bootwithflame.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chenxixiang.bootwithflame.mongodb.common.PageVo;
import com.chenxixiang.bootwithflame.mongodb.domain.Partner;
import com.chenxixiang.bootwithflame.service.interfaces.PartnerService;
import com.chenxixiang.bootwithflame.web.common.CommonConstant;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/partner")
public class PartnerController {
	@Autowired
	PartnerService partnerService;

	@ApiOperation(value = "新增单个伙伴用户", notes = "新增单个伙伴用户")
	@RequestMapping(method = RequestMethod.POST, value = "/insert")
	public @ResponseBody String insert(@RequestBody Partner partner) {
		if (partnerService.insertPartner(partner) == 1) {
			return CommonConstant.SUCCESS;
		} else {
			return CommonConstant.FAILED;
		}
	}

	@ApiOperation(value = "按用户名查询", notes = "按用户名查询")
	@GetMapping(value = "/selectByName")
	public @ResponseBody PageVo<Partner> selectByName(@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer pageIndex, @RequestParam(required = false) Integer pageSize) {
		if (pageIndex == null || pageIndex < 1) {
			pageIndex = 1;
		}
		if (pageSize == null || pageSize < 1) {
			pageSize = 20;
		}
		return partnerService.selectByName(name, pageIndex, pageSize);

	}
}
