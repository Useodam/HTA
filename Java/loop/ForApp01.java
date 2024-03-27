package loop;

public class ForApp01 {
	public static void main(String[] args) {
		
		/*
		 * for문
		 * 	지정된 반복횟수만큼 블록내 수행문을 반복수행한다
		 * 
		 * 형식
		 * 		for (초기식; 조건식; 증감식) {
		 * 			수행문;
		 * 			수행문;
		 * 		}
		 * 
		 * 반복의 횟수는 초기식, 조건식, 증감식을 이용해서 지정한다.
		 * 실행순서
		 * 					-- 증감식 <-------
		 * 					|                |
		 * 		초기식 -> 조건식 -> 수행문 -->
		 * 
		 * for문의 초기식에 생성한 변수는 
		 * 		조건식, 증감식, 블록내 수행문에서만 사용가능하다.
		 * for문의 초기식, 조건식, 증감식은 생략할 수 있다.
		 */
		
		// 지정된 수행문을 5번 실행하는 for문
		for (int i=1; i<=5; i++) {
			System.out.println("i의 값 : "+i);
		}
			
		// for문의 초기식, 조건식, 증감식은 생략할 수 있다.
		int a = 1;
		for (; a<=5; a++) {
			System.out.println("a의 값 : "+a);
		}
		
		int b = 1;
		for (; b<=5; ) {
			System.out.println("b의 값 : "+b);
			b++;
		}
		
		// 모든걸 생략하면 무한반복문이 실행이 된다
		for(;;) {
			System.out.println("11111111111");
		}
	}
}
