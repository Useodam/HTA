package constructor;

public class Product {
	
	int no;
	String name;
	String maker;
	int price;
	int stock;
	boolean soldOut;

	
	/*
	 * 기본 생성자 메소드
	 * 	- 기본 생성자 메소드는 매개변수가 하나도 없는 생성자 메소드다.
	 * 	- 기본 생성자 메소드는 컴파일러가 자동으로 추가한다.
	 *    + 클래스에 정의된 생성자 메소드가 하나도 없는 경우, 컴파일러가
	 *      소스코드로 실행파일을 만들 때 실행파일에 자동으로 추가한다.
	 *    + 생성자 메소드가 하나라도 존재하면 자동으로 추가되지 않는다. 
	 */
	
	// 기본 생성자 메소드
	// 기본 생성자 메소드는 매개변수가 하나도 없는 생성자 메소드다.
	/*
	 * 생성자 메소드 중복정의
	 * 	- 기본 생성자 메소드(매개변수가 하나도 없는 생성자 메소드) 말고,
	 * 	  매개변수를 가지는 생성자 메소드를 여러개 중복정의할 수 있다.
	 */
	
	public Product() {
		
	}
	
	
	public Product(int no, String name, String maker, int price) {
		this(no, name, maker, price, 3);
		
	}
	
	public Product(int no, String name, String maker, int price, int stock) {
		
		this.no = no;
		this.name = name;
		this.maker = maker;
		this.price = price;
		this.stock = stock;
		this.soldOut = false;
	}
	
	// 멤버 메소드 정의하기
	public void printProduct() {
		System.out.println("상품번호 : " + no);
		System.out.println("상품이름 : " + name);
		System.out.println("제조회사 : " + maker);
		System.out.println("판매가격 : " + price);
		System.out.println("재고수량 : " + stock);
		System.out.println("재고여부 : " + soldOut);
		System.out.println();
	}
}
