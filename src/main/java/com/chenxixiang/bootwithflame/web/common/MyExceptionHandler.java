package com.chenxixiang.bootwithflame.web.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyExceptionHandler {
	private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public <T> WebResult<T> exceptionGet(Exception e) {

		if (e instanceof MyException) {
			MyException MyException = (MyException) e;
			return WebResultUtil.error(MyException.getCode(), MyException.getMessage());
		}

		LOGGER.error("【系统异常】{}", e);
		return WebResultUtil.error(ExceptionEnum.UNKNOW_EXCEPTION);

	}
}
