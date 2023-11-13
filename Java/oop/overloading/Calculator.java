package overloading;

public class Calculator {
	/* 메소드 중복 정의
	 * 	하나의 클래스 안에 같은 이름의 메소드를 여러개 정의하는 것.
	 * 	목적
	 * 		유사한 기능은 동일한 이름으로 일관되게 정의하자
	 *  	객체의 기능에 대한 사용성이 높아진다
	 *  	
	 * 	조건
	 * 		매개변수의 개수가 달라야한다.
	 * 		매개변수의 타입이 달라야한다.
	 * 		매개변수의 이름이 다른건 오버로딩의 조건에 해당하지 않는다
	 */
	
	/**
	 * 정수 2개를 전달받아서 덧셈을 수행하고, 그 결과를 반환한다
	 * @param x	첫번째 정수
	 * @param y 두번째 정수
	 * @return	덧셈 결과값
	 */
	
	int sum(int x, int y) {
		System.out.println("(정수 + 정수)의 덧셈을 실행한다.");
		int result = x + y;
		
		return result;
	}
	
	/**
	 * 정수 3개를 전달받아서 덧셈을 수행하고 그 결과를 반환한다
	 * @param x	첫번째 정수
	 * @param y	두번째 정수
	 * @param z 세번째 정수
	 * @return	덧셈 결과값
	 */
	int sum(int x, int y, int z) {
		System.out.println("(정수 + 정수 + 정수)의 덧셈을 실행한다.");
		int result = x + y + z;
		
		return result;
	}
	
	double sum(double x, double y) {
		System.out.println("(실수 + 실수)의 덧셈을 실행한다.");
		double result = x + y;
		return result;
	}
	
	double sum(double x, int y) {
		System.out.println("(실수 + 정수)의 덧셈을 실행한다.");
		double result = x + y;
		return result;
	}
	
	double sum(int x, double y) {
		System.out.println("(정수 + 실수)의 덧셈을 실행한다.");
		double result = x + y;
		return result;
	}
	
	/* 매개변수의 이름이 다른건 오버로딩 조건에 해당하지 않는다
	double sum(int a, double b) {
		System.out.println("(정수 + 실수)의 덧셈을 실행한다.");
		double result = a + b;
		return result;
	}
	*/
}
