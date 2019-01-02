package com.chenxixiang.bootwithflame.mongodb.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.chenxixiang.bootwithflame.mongodb.domain.Message;

@RepositoryRestResource(collectionResourceRel = "message", path = "message")
public interface MessageRepository extends MongoRepository<Message, String> {

	public List<Message> findByUser1Id(String user1Id);

	@Query(value = "{$or:[{'user1Id':?0},{'user1Id':?1}]}",
			fields = "{'sessionId':1, 'beginTime':2, 'endTime':3}")
	public Page<Message> findMessageSessionByUserId(String user1Id, String user2Id, Date timeFrom,
			Date timeTo, Pageable pageable);

}
