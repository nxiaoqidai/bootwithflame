package com.chenxixiang.bootwithflame.dao.pojo;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class User {
	@ApiModelProperty(hidden = true)
	private String id;

	private String name;

	@ApiModelProperty(hidden = true)
	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
