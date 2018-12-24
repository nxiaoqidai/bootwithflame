package com.chenxixiang.bootwithflame.web.common;

public class MyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Integer code;

	public MyException(ExceptionEnum exceptionEnum) {
		super(exceptionEnum.getMsg());
		this.code = exceptionEnum.getCode();
	}

	public MyException(Integer errorCode, String msg) {
		super(msg);
		this.code = errorCode;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
