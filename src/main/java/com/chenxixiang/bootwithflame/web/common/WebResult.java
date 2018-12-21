package com.chenxixiang.bootwithflame.web.common;

public class WebResult<T> {

	// error_code 状态值：200 为成功，其他数值代表失败
	private Integer status;

	// error_msg 错误信息，若status为0时，为success
	private String msg;

	// content 返回体报文的出参，使用泛型兼容不同的类型
	private T data;

	public WebResult() {
		this.status = 200;
		msg = "SECCESS";
	}

	public WebResult(Integer status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer code) {
		this.status = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData(Object object) {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	@Override
	public String toString() {
		return "Result{" + "status=" + status + ", msg='" + msg + '\'' + ", data=" + data + '}';
	}
}