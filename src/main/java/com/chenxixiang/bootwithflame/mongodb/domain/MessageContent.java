package com.chenxixiang.bootwithflame.mongodb.domain;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class MessageContent {

	@ApiModelProperty(hidden = true)
	String speaker;

	@ApiModelProperty(hidden = true)
	String content;

	@ApiModelProperty(hidden = true)
	Date speakTime;

	public MessageContent(String speaker, String content, Date speakTime) {
		this.speaker = speaker;
		this.content = content;
		this.speakTime = speakTime;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSpeakTime() {
		return speakTime;
	}

	public void setSpeakTime(Date speakTime) {
		this.speakTime = speakTime;
	}

}
