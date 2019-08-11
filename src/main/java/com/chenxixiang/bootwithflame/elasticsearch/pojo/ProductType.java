package com.chenxixiang.bootwithflame.elasticsearch.pojo;

import java.util.Date;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "product_type", type = "normal")
public class ProductType {
	private String name;
	private String typePath;
	private String brand;
	private Date createTime;
	private Date updateTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypePath() {
		return typePath;
	}

	public void setTypePath(String typePath) {
		this.typePath = typePath;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
