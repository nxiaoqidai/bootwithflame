package com.chenxixiang.bootwithflame.web.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {
	private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public WebResult exceptionGet(Exception e) {

		if (e instanceof NullParamException) {
			NullParamException MyException = (NullParamException) e;
			return ResultUtil.error(MyException.getParamType(), MyException.getMessage());
		}

		LOGGER.error("【系统异常】{}", e);
		return ResultUtil.error(ExceptionEnum.UNKNOW_Exception);

	}
}
