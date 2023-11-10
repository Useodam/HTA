package day1;

public class BookApp2 {
	public static void main(String[] args) {

		// 책정보를 표현하는 Book객체를 생성하고, 책정보를 대입하기
		
		// 1. 책정보를 표현하는 Book 객체 생성하기
		Book book1 = new Book();
		// 2. boo1이 참조하는 Book 객체의 멤버변수에 책정보 대입하기
		book1.title = "박상효의 영단어 콘서트";
		book1.author = "박상효";
		book1.price = 18000;
		book1.discountRate = 0.15;
		book1.publisher = "성안당";
		book1.stock = 20;
		book1.soldOut = false;
		
		// 3. book1이 참조하는 Book 객체의 멤버변수에 저장된 값 출력하기
		System.out.println("제목 : " + book1.title);
		System.out.println("저자 : " + book1.author);
		System.out.println("가격 : " + book1.price);
		System.out.println("할인율 : " + book1.discountRate);
		System.out.println("출판사 : " + book1.publisher);
		System.out.println("재고 : " + book1.stock);
		System.out.println("재고여부 : " + book1.soldOut);
	}
}
