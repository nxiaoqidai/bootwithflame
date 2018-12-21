package com.chenxixiang.bootwithflame.web.common;

public class NullParamException extends RuntimeException {
	private String paramName;
	private String paramType;

	public NullParamException(String name, String type) {
		super();
		this.paramName = name;
		this.paramType = type;
	}

	@Override
	public String getMessage() {

		return "The " + getParamType() + " : " + getParamName() + "  must not be null";
	}

	public String getParamName() {
		return paramName;
	}

	public String getParamType() {
		return paramType;
	}

}
