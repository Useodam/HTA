package io5;

import java.io.Serializable;

public class User implements Serializable {

	
	private static final long serialVersionUID = -3137364349244922093L;
	private int no;
	private String id;
	private transient String password;
	private String email;
	
	public User(int no, String id, String password, String email) {
		
		this.no = no;
		this.id = id;
		this.password = password;
		this.email = email;
	}

	public int getNo() {
		return no;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}
	
	
	
}
