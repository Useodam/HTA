package variable;

public class Sample06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 논리형 타입
		 * 	boolean 타입
		 * 
		 * 	논리값은 true, false 2가지 값만 존재한다.
		 * 	true와 false는 각각 참, 거짓을 표현하는 자바의 예약어다.
		 * 	논리값은 boolean 타입의 변수에만 대입할 수 있다
		 * 
		 * 	예)
		 * 	boolean b1 = true;
		 * 	boolean b2 = false;
		 * 
		 * 	논리값은 참, 거짓 2가지 상태만 존재하는 데이터를 표현할 때 사용한다.
		 * 	예)
		 * 		boolean 합격여부 = true;
		 * 		boolean 존재여부 = false;
		 * 		boolean 배송완료여부 = true;
		 * 		boolean 퇴사여부 = false;
		 * 
		 * 		boolean 합격여부 = "true";	// 문자열은 boolean 타입 변수에 대입할 수 없다.
		 */
		
		boolean b1 = true;
		boolean b2 = 100 < 10;
		
		System.out.println(b1);
		System.out.println(b2);
	}

}
