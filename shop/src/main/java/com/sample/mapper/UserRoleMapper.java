package com.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.UserRole;

@Mapper
public interface UserRoleMapper {

	void insertUserRole(UserRole userRole);
	void deleteUserRole(UserRole userRole);
	List<UserRole> getUserRolesByUserNo(int userNo);
}
