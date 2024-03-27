package wrapper;

public class IntegerApp1 {

	public static void main(String[] args) {
		
		/*
		 * Integer
		 * 	- int의 wrapper 클래스다.
		 * 
		 * 	- 주요 상수
		 * 	 	MIN_VALUE
		 * 			int 기본자료형의 최소값
		 * 		MAX_VALUE
		 * 			int 기본자료형의 최대값
		 * 	
		 * 	-주요 메소드
		 * 		정적 메소드
		 * 			static int Integer.parseInt(String str)
		 * 				전달받은 문자열(숫자로 구성된 문자열)을 정수로 변환해서 반환한다
		 * 	
		 * 			static int Integer.parseInt(String str, int radix)
		 * 				문자열과 진법을 전달받아서 정수로 변환해서 반환한다
		 * 
		 * 			static String toBinaryString(int i)
		 * 				전달받은 정수를 이진수로 구성된 문자열로 반환한다
		 * 
		 * 			static String toOctalString(int i)
		 * 				전달받은 정수를 8진수로 구성된 문자열로 반환한다
		 * 
		 * 			static String toHexString(int i)
		 * 				전달받은 정수를 16진수로 구성된 문자열로 반환한다
		 * 
		 * 			static int min(int x, int y)
		 * 				작은 수를 반환한다
		 * 			static int max(int x, int y)
		 * 				큰 수를 반환한다
		 * 			static int sum(int x, int y)
		 * 				합계를 반환한다
		 * 
		 * 			static Integer valueOf(int i)
		 * 				전달받은 정수를 포함하는 Integer객체의 주소값을 반환한다
		 * 			static Integer valueOf(String str)
		 * 				전달받은 문자열이 표현하는 정수를 포함하는 Integer객체의 주소값을 반환한다
		 * 			static Integer valueOf(String str, int radix)
		 * 				정수(전달받은 문자열이 표현하는)를 포함하는 Integer객체의 주소값을 반환한다
		 * 
		 * 		멤버 메소드
		 * 			int intValue()
		 * 				Integer객체가 가지고 있는 정수값을 반환한다
		 * 				* 오토언박싱이 지원되면서 사용할 일이 거의 없음
		 */
		
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		// 문자열을 정수로 변환하기
		int a = Integer.parseInt("1000");	// a에는 1000이 대입
		int b = Integer.parseInt("34");		// b에는 34가 대입
		int c = Integer.parseInt("100", 16);		
		int d = Integer.parseInt("100", 10);		
		int e = Integer.parseInt("100", 8);		
		int f = Integer.parseInt("100", 2);		
		
		// 정수 123을 각각 2진수, 8진수, 16진수 텍스트로 변환하기
		String str1 = Integer.toBinaryString(123);
		String str2 = Integer.toOctalString(123);
		String str3 = Integer.toHexString(123);
		
		
		// Integer객체 생성(획득)하기
		Integer i1 = 100;
		Integer i2 = Integer.valueOf(100);
		Integer i3 = Integer.valueOf("100");
		Integer i4 = Integer.valueOf("100",16);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
	}
}
