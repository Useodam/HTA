package annotation;

import java.util.Date;

public class Product {

	private int no;
	private String name;
	private int price;
	
	@CreatedAt
	private Date createdDate;
	
	private Date updatedDate;
	
	
	public Product(int no, String name, int price) {
		// TODO Auto-generated constructor stub
		this.no = no;
		this.name = name;
		this.price = price;
	}


	@Override
	public String toString() {
		return "Product [no=" + no + ", name=" + name + ", price=" + price + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}
	
	
	
}
