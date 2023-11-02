package control;

import java.util.Scanner;

public class Practice01 {
	public static void main(String[] args) {
	
		/*
		 *	Scanner
		 *		값을 읽어오는 기능이 제공된다.
		 *		java.base. 모듈의 java.util 패키지에 위치하는 클래스다.
		 *
		 * 		next()	: 입력한 값을 문자열로 제공하는 기능이다.
		 * 		nextInt()	: 입력한 값을 정수로 제공하는 기능이다.
		 * 		nextDouble()	: 입력한 값을 실수로 제공하는 기능이다.
		 */	
		
		/*
		 * 두 수를 입력받아서 더 큰 수를 출력하기
		 */
		
		// 표준입력장치인 키보드에서 입력받는 명령여 Scanner(System.in)
		// Resource leak: 'sc' is never closed : 자원이 세고있다라는 뜻
		Scanner sc = new Scanner(System.in);
		
		// 입력값을 읽어서 정수로 반환한다.
		System.out.print("첫번째 숫자 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두번째 숫자 입력 : ");
		int num2 = sc.nextInt();
		
		System.out.println("첫번째 정수 : "+num1);
		System.out.println("두번째 정수 : "+num2);
		
		if (num1 > num2) {
			System.out.println("큰 수 : "+num1);
		} else {
			System.out.println("큰 수 : "+num2);
		}
		
		sc.close();
		
	}
}
