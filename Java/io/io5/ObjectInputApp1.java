package io5;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputApp1 {

	public static void main(String[] args)throws Exception {
		
		String path = "src/io5/user.obj";
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
		
		// 역직렬화
		User user = (User)in.readObject();
		
		System.out.println(user.getNo());
		System.out.println(user.getId());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
	}
}
