package lang;

public class StringApp3 {

	public static void main(String[] args) {
		
		/*
		 * boolean equals(Object str)
		 * 	- 지정된 문자열과 문자열의 내용을 비교해서 일치하면 true를 반환한다
		 * 	- 대소문자를 구분한다
		 * 	- Object의 equals(Object obj)를 재정의한 메소드다.
		 * 	  단, 문자열의 내용을 비교하도록 정의한 메소드다
		 * 
		 * boolean equalsIngoreCase(String str)
		 * 	- 지정된 문자열과 문자열의 내용을 비교해서 일치하면 true를 반환한다
		 * 	- 단, 문자가 대소문자를 제공하는 경우 대소문자 상관없이 비교한다
		 */
		
		String str1 = "홍길동";
		String str2 = "홍길동";
		
		String str3 = new String("홍길동");
		String str4 = new String("홍길동");
		
		System.out.println("주소값 비교 :"+ (str1 == str2));
		System.out.println("주소값 비교 :"+ (str3 == str4));
		
		System.out.println("문자열 내용 비교 :" + str1.equals(str2));	// true
		System.out.println("문자열 내용 비교 :" + str3.equals(str4));	// true
		System.out.println("문자열 내용 비교 :" + str1.equals(str3));	// true
		
		
		String str5 = "Hello";
		String str6 = "hello";
		
		System.out.println("대소문자 구분 :" + str5.equals(str6));
		System.out.println("대소문자 무시 :" + str5.equalsIgnoreCase(str6));
		
		
		
		
		
		
		
		
	}
}
