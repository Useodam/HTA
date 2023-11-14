package myConstructor;

public class Product {
	
	int number;		// 제품 번호
	String name; 	// 제품 이름
	String maker;	// 브랜드
	int price;		// 제품 가격
	int stock;		// 잔여 수량
	boolean soldOut; // 품절유무
	
	// 기본 생성자
	public Product() {
		
	}
	
	public Product(int number, String name, String maker, int price) {
		this.number = number;
		this.name = name;
		this.maker = maker;
		this.price = price;
		stock = 5;
		soldOut = false;
	}
	
	public Product(int number, String name, String maker, int price, int stock) {
		super();
		this.number = number;
		this.name = name;
		this.maker = maker;
		this.price = price;
		this.stock = stock;
		soldOut = false;
	}
	
	// 객체의 정보를 호출하는 메소드
	public void printProduct() {
		System.out.println("제품번호 : " + number);
		System.out.println("제품명 : " + name);
		System.out.println("브랜드 : " + maker);
		System.out.println("판매가격 : " + price);
		System.out.println("재고수량 : " + stock);
		System.out.println("판매여부 : " + soldOut);
	}
	
}
