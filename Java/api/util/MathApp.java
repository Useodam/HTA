package util;

public class MathApp {

	public static void main(String[] args) {
		
		/*
		 * java.lang.Math 클래스
		 * 	- 수학연산과 관련된 클래스 메소드를 제공하는 클래스
		 * 	- Math 클래스는 상수와 클래스 메소드만으로 구성된 클래스
		 */
		
		// Math 클래스의 상수값
		System.out.println(Math.PI);
		System.out.println(Math.E);
		
		/*
		 * int abs(int x), long abs(long x), double abs(double x)
		 * 	- 절대값을 반환한다
		 */
		
		System.out.println("절대값: "+Math.abs(10.5));
		System.out.println("절대값: "+Math.abs(-10));
		
		/*
		 * int min(int x, int y), long min(long x, long y), double min(double x, double y)
		 * 	- 두 수 중에서 작은 숫자를 반환한다
		 * 
		 * int max(int x, int y), long max(long x, long y), double max(double x, double y)
		 * 	- 두 수 중에서 큰 숫자를 반환한다
		 */
		
		System.out.println("작은 수: "+Math.min(10, 50));
		System.out.println("큰 수: "+Math.max(10, 50));
		
		/*
		 * double pow(double a, double b)
		 * 	- a의 값을 b의 값만큼 제곱한 수를 반환한다
		 */
		
		System.out.println("1번째의 값을 2번째의 값만큼 곱한 값: "+Math.pow(2, 4));
		
		/*
		 * int round(float x), long round(double x)
		 * 	- 반올림된 값을 반환한다. (일의 자리수로 반올림)
		 */
		
		System.out.println("반올림: "+Math.round(3.14));
		System.out.println("반올림: "+Math.round(7.85));
		
		/*
		 * double floor(double x)
		 * 	- 내림함수 (전달받은 실수값에 대한 내림값을 반환)
		 * double ceil(double x)
		 * 	- 올림 함수 (전달받은 실수값에 대한 올림값을 반환)
		 */
		
		System.out.println("내림함수: "+Math.floor(5.7));
		System.out.println("내림함수: "+Math.floor(8.1));
		System.out.println("올림함수: "+Math.ceil(8.9));
		System.out.println("올림함수: "+Math.ceil(2.5));
	}
}
