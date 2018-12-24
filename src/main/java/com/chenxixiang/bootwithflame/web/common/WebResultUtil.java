package com.chenxixiang.bootwithflame.web.common;

public class WebResultUtil {

	/**
	 * 返回成功，传入返回体具体出參
	 * 
	 * @param object
	 * @return
	 */
	public static <T> WebResult<T> success(T object) {
		WebResult<T> result = new WebResult<T>();
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
	public static <T> WebResult<T> success() {
		return success(null);
	}

	/**
	 * 自定义错误信息
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static <T> WebResult<T> error(Integer code, String msg) {
		WebResult<T> result = new WebResult<T>();
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
	public static <T> WebResult<T> error(ExceptionEnum exceptionEnum) {
		WebResult<T> result = new WebResult<T>();
		result.setStatus(exceptionEnum.getCode());
		result.setMsg(exceptionEnum.getMsg());
		result.setData(null);
		return result;
	}
}
