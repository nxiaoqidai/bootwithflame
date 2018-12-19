package com.chenxixiang.bootwithflame.dao.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chenxixiang.bootwithflame.dao.pojo.User;

@Mapper
public interface UserMapper {
	// @Select("select * from user")
	List<User> selectAll();

	List<User> select(User user);

	int insert(User user);

	int delete(User user);
}
