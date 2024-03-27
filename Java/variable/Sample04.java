package variable;


public class Sample04 {
	public static void main(String[] args) {
		
		/*
		 * 문자 자료형
		 * char
		 * 
		 * 문자 자료형 타입의 변수는 오직 한 문자만 저장할 수 있다
		 * 문자 자료형의 유니코드를 지원하기 때문에 전세계의 모든 글자를 표현할 수 있다.
		 * 
		 * 만약, 1 글자 이상을 저장하는 경우에는 String 객체를 사용한다
		 * 대부분의 경우 문자 하나로 이루어진 값이라 하더라도 char보다는 String 타입으로 다룬다
		 */
		
		char ch1 = 'A';			// 문자값을 대입한다.
		char ch2 = '가';	
		char ch3 = '\uAC00';	// 유니코드(16진수)에 해당하는 문자가 대입된다.
		char ch4 = '\uAC01';
		char ch5 = 65;			// 십진수 65는 유니코드 41이다. 즉, 유니코드 41에 해당하는 글자가 대입된다.
		char ch6 = 44032;		// 십진수 44032는 유니코드 AC00이다. 즉, '가'가 대입된다.
		
		System.out.println("ch1의 값 :" + ch1);
		System.out.println("ch2의 값 :" + ch2);
		System.out.println("ch3의 값 :" + ch3);
		System.out.println("ch4의 값 :" + ch4);
		System.out.println("ch5의 값 :" + ch5);
		System.out.println("ch6의 값 :" + ch6);
	}
}
