package variable;

public class Sample02 {
	public static void main(String[] args) {
		/*
		 * 정수 자료형
		 * 	byte, short, int, long
		 * 
		 * 	- 정수 자료형의 default 자료형은 int다.
		 * 	- 대부분의 프로그램에서 정수값은 int 범위내에 속하기 때문에
		 * 	  특별한 경우가 아니면 정수를 저장하는 변수는 int 타입으로 생성한다
		 * 	  (byte 타입은 입출력에서 바이너리 데이터를 다룰 때 사용한다.)
		 * 	  (long 타입은 int범위를 초과하는 정수값을 다룰 때 사용한다.
		 * 	   대표적인 값은 은행 예금의 잔액 등이다.)
		 */
		
		// 정수 자료형타입의 변수 생성과 초기화
		int num1 = 100;	// 양의 정수값을 저장한다
		int num2 = -100;	// 음의 정수값을 저장한다
		int num3 = 100_000_000;	// 자릿수가 표현된 정수값을 저장한다
		int num4 = 0100;	// 8진법으로 표현된 정수값을 저장한다
		int num5 = 0x100;	// 16진법으로 표현된 정수값을 저장한다
		
		System.out.println("num1의 값 : " + num1);
		System.out.println("num2의 값 : " + num2);
		System.out.println("num3의 값 : " + num3);
		System.out.println("num4의 값 : " + num4);
		System.out.println("num5의 값 : " + num5);
		
		// int 범위를 초과하는 정수값의 저장 및 출력
		// 정수값이 int의 범위를 초과하는 경우, long 타입의 변수에 저장해야 한다
		// 정수값이 int의 범위를 초과하는 경우, 정수값 끝에 L 혹은 l을 붙인다
		long num6 = 10_000_000_000L;
		System.out.println("num6의 값 : " + num6);
		
		// 계산의 결과가 int 범위를 초과하는 경우
		int num7 = 123456789;
		int num8 = 123;
		long num9 = num7*num8;
		long num10 = (long)num7*num8;
		System.out.println("num9의 값 : " + num9);	// -1994684137가 출력됨
		System.out.println("num10의 값 : " + num10);
		
	}
}
