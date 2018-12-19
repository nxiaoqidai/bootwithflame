package com.chenxixiang.bootwithflame.service.impls;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenxixiang.bootwithflame.mongodb.domain.Message;
import com.chenxixiang.bootwithflame.mongodb.domain.MessageContent;
import com.chenxixiang.bootwithflame.mongodb.repository.MessageRepository;
import com.chenxixiang.bootwithflame.service.interfaces.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageRepository messageRepository;

	@Override
	public int insert(Message message) {
		try {
			message.setSessionId(UUID.randomUUID().toString());
			fillTrashContent(message);
			messageRepository.save(message);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public List<Message> find(Message message) {

		return messageRepository.findByUser1Id(message.getUser1Id());
	}

	private Message fillTrashContent(Message message) {
		Calendar calendar = new Calendar.Builder().build();
		message.setBeginTime(calendar.getTime());
		calendar.add(Calendar.SECOND, 4);
		List<MessageContent> content = new ArrayList<>();
		MessageContent mc0 = new MessageContent(message.getUser1Id(), "Hi, " + message.getUser2Id(),
				calendar.getTime());
		calendar.add(Calendar.SECOND, 3);
		MessageContent mc1 = new MessageContent(message.getUser2Id(),
				"丢你咩, " + message.getUser1Id(), calendar.getTime());
		calendar.add(Calendar.SECOND, 3);
		MessageContent mc2 = new MessageContent(message.getUser2Id(), "傻逼, 债见 ",
				calendar.getTime());
		content.add(mc0);
		content.add(mc1);
		content.add(mc2);
		message.setContent(content);
		message.setEndTime(calendar.getTime());
		return message;
	}

}
