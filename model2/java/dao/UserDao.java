package dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import ibatis.IbatisUtil;
import vo.User;

public class UserDao {

	private final SqlMapClient ibatis = IbatisUtil.getsqlMapClient();
	
	public User getUserById(String id) throws SQLException {
		return (User)ibatis.queryForObject("users.getUserById", id);
	}
	
	public User getUserByEmail(String email) throws SQLException {
		return (User)ibatis.queryForObject("users.getUserByEmail", email);
	}

	public void insertUser(User user) throws SQLException {
		ibatis.insert("users.insertUser", user);
	}
}
