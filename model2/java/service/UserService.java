package service;

import java.sql.SQLException;

import dao.UserDao;
import vo.User;

public class UserService {

	private final UserDao userDao = new UserDao();
	
	/**
	 * 신규 사용자 정보를 전달받아서 가입처리한다
	 * @param user
	 * @throws SQLException
	 */
	public void register(User user) throws Exception{
		User savedUser = userDao.getUserById(user.getId());
		if(savedUser != null) {
			throw new RuntimeException("사용자 정보가 이미 존재합니다.");
		}
		
		savedUser = userDao.getUserByEmail(user.getEmail());
		if(savedUser != null) {
			throw new RuntimeException("사용자 정보가 이미 존재합니다.");
		}
		
		userDao.insertUser(user);
	}
	
	/**
	 * 아이디, 비밀번호를 전달받아서 사용자 인증작업을 수행한다.
	 * 사용자 인증이 완료되면 사용자 정보를 반환하고, 사용자 인증에 실패하면 예외를 발생시킨다
	 * @param id 아이디
	 * @param password 비밀번호
	 * @return 인증이 완료된 사용자 정보
	 * @throws Exception
	 */
	public User login(String id, String password) throws Exception {
		User user = userDao.getUserById(id);
		if(user == null) {
			throw new RuntimeException("아이디 혹은 비밀번호가 올바르지 않습니다");
		}
		
		if(!user.getPassword().equals(password)) {
			throw new RuntimeException("아이디 혹은 비밀번호가 올바르지 않습니다");
		}
		
		return user;
	}
}
