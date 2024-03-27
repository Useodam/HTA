package io7;

import java.text.Format;
import java.text.MessageFormat;

public class Customer {

	private int no;
	private String id;
	private String password;
	private String name;
	private String email;
	private boolean deleted;
	
	public Customer() {}
	
	public Customer(int no, String id, String name, String email) {
		this.no = no;
		this.id = id;
		this.name = name;
		this.email = email;
		
		this.password = "qwer1234";	// 초기비밀번호는 qwer1234 로 한다
		this.deleted = false;		// 초기삭제여부는 false 다
	}

	
	
	public Customer(int no, String id, String password, String name, String email, boolean deleted) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.deleted = deleted;
	}
	

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public String toText() {
		return MessageFormat.format("{0},{1},{2},{3},{4},{5}", no,id,password,name,email,deleted);
	}
	
	public static Customer toCustomer(String text) {
		String [] items = text.split(",");
		
		// 배열에서 해당 위치를 값을 조회해서 적절한 타입으로 변환한다
		int no = Integer.valueOf(items[0]);
		String id = items[1];
		String password = items[2];
		String name = items[3];
		String email = items[4];
		boolean deleted = Boolean.valueOf(items[5]);
		
		return new Customer(no,id,password,name,email,deleted);
	}

	
}
