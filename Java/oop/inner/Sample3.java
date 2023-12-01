package inner;

import java.security.PublicKey;

public class Sample3 {
	
	private int value1;
	static int value2;
	
	public void method2() {
		
	}
	
	public static void method3() {
		
	}
	
	public void method1() {
		
		// lv
		int x = 10;
		int y = 20;
		
		x = 30;
		
		/*
		 * 로컬 내부 클래스
		 * 	- 메소드 내부에 정의된 클래스다.
		 * 	- 접근제한자, static을 붙일 수 없다
		 * 	- 해당 메소드가 실행되는 동안만 사용가능하고, 메소드내부에서만 사용가능하다
		 * 	- 로컬 내부 클래스에서는 외부클래스의 모든 변수, 모든 메소드를 사용할 수 있다.
		 * 	- 로컬 내부 클래스가 위치한 메소드의 지역변수 중에서는 상수처럼 동작하는 변수만 사용가능하다
		 */
		class Inner3 {
			
			public void method() {
				System.out.println(value1);
				System.out.println(value2);
//				System.out.println(x);		// 컴파일 오류, 값이 변하는 lv는 사용할 수 없다
				System.out.println(y);
				method2();
				method3();
			}
		}
	}
}
