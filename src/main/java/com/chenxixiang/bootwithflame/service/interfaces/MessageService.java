package com.chenxixiang.bootwithflame.service.interfaces;

import java.util.List;

import com.chenxixiang.bootwithflame.mongodb.domain.Message;
import com.chenxixiang.bootwithflame.otherdto.MessageSessionsInfo;

public interface MessageService {
	public int insert(Message message);

	public List<Message> find(Message message);

	public List<MessageSessionsInfo> getSessionInfo(String userId, Long startTime, Long endTime);
}
