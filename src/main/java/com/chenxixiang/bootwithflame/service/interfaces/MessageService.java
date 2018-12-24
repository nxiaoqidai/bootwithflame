package com.chenxixiang.bootwithflame.service.interfaces;

import java.util.List;

import com.chenxixiang.bootwithflame.mongodb.domain.Message;

public interface MessageService {
	public int insert(Message message);

	public List<Message> find(Message message);

	public List<Message> getSessionInfo(String userId, long startTime, long endTime);
}
