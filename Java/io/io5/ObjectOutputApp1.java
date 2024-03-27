package io5;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputApp1 {

	public static void main(String[] args) throws Exception{
		
		/*
		 * ObjectOutputStream
		 * 	- 객체를 직렬화해서 스트림으로 전송한다
		 * 	- ObjectOutputStream의 writeObject(Object obj)는
		 * 	  지정된 객체를 직렬화해서 연결된 스트림으로 내보낸다
		 */
		
		// 객체를 직렬화하기 - 객체를 스트림으로 출력해보기
		User user = new User(100, "고길동", "qwer1234", "gildong@gmail.con");
		
		String path = "src/io5/user.obj";
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
		
		// 객체를 직렬화한다
		out.writeObject(user);
		
		out.close();
	}
}
