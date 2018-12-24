package com.chenxixiang.bootwithflame.web.common;

public enum ExceptionEnum {

	UNKNOW_Exception(-1, "未知错误"), USER_NOT_FIND(-101, "用户不存在"), PARAM_NULL(10, "参数不足");

	private Integer code;

	private String msg;

	ExceptionEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}