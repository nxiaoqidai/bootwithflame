package com.chenxixiang.bootwithflame.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.chenxixiang.bootwithflame.mongodb.domain.Message;

@RepositoryRestResource(collectionResourceRel = "message", path = "message")
public interface MessageRepository extends MongoRepository<Message, String> {
	public List<Message> findByUser1Id(String user1Id);
}
