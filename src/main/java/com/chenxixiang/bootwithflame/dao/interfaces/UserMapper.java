package com.chenxixiang.bootwithflame.dao.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.chenxixiang.bootwithflame.dao.pojo.User;

@Mapper
public interface UserMapper {
	@Select("select * from user")
	List<User> selectAll();
}
