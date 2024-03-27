package lang;

import java.util.function.BooleanSupplier;

public class ContactApp2 {

	public static void main(String[] args) {
		Contact c1 = new Contact();
		Contact c2 = new Contact();
		
		c1.name = "홍길동";
		c1.phone = "010-1234-5678";
		c1.email = "hong@gmail.com";
		c1.company = "HTA";
		
		c2.name = "홍길동";
		c2.phone = "010-1234-5678";
		c2.email = "hong@gmail.com";
		c2.company = "HTA";
		
		System.out.println(c1);
		System.out.println(c2);
		
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		
		/*
		 * Object의 equals(Object other)
		 * 	- 동일한 객체인지 비교하는 메소드다.
		 * 	- 두 객체의 주소값을 비교한다 (동일성 비교)
		 * 
		 * 	두 객체가 같은 값을 가지고 있으면 같은 객체로 판단하게 하기
		 * 	- equals(Object other)를 재정의한다
		 * 
		 */	
		boolean result1 = c1.equals(c2);
		boolean result2 = c1 == c2;
		
		System.out.println(result1);
		System.out.println(result2);
		
	}
}
