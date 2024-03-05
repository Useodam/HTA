package com.sample.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.User;

@Mapper
public interface UserMapper {

	void insertUser(User user);
	
	User getUserById(String id);
	User getUserByEmail(String email);
	User getUserByNo(int no);
	
	void updatedUser(User user);
}
