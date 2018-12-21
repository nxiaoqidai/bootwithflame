package com.chenxixiang.bootwithflame.web.common;

public class ResultUtil {

	/**
	 * 返回成功，传入返回体具体出參
	 * 
	 * @param object
	 * @return
	 */
	public static <T> WebResult success(T object) {
		WebResult result = new WebResult();
		result.setStatus(0);
		result.setMsg("success");
		result.setData(object);
		return result;
	}

	/**
	 * 提供给部分不需要出參的接口
	 * 
	 * @return
	 */
	public static WebResult success() {
		return success(null);
	}

	/**
	 * 自定义错误信息
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static WebResult error(Integer code, String msg) {
		WebResult result = new WebResult();
		result.setStatus(code);
		result.setMsg(msg);
		result.setData(null);
		return result;
	}

	/**
	 * 返回异常信息，在已知的范围内
	 * 
	 * @param exceptionEnum
	 * @return
	 */
	public static WebResult error(ExceptionEnum exceptionEnum) {
		WebResult result = new WebResult();
		result.setStatus(exceptionEnum.getCode());
		result.setMsg(exceptionEnum.getMsg());
		result.setData(null);
		return result;
	}
}
