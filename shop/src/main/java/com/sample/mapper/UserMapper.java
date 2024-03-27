package com.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.User;

@Mapper
public interface UserMapper {

	List<User> getAllUsers();
	void insertUser(User user);
	
	User getUserById(String id);
	User getUserByEmail(String email);
	User getUserByNo(int no);
	
	void updatedUser(User user);
}
