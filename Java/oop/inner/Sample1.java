package inner;

/*
 * 멤버내부클래스(인스턴스 내부클래스)를 포함하는 클래스
 */
public class Sample1 {

	/*
	 * 멤버 내부 클래스
	 * 	- 객체 생성 후 사용가능한 내부 클래스다
	 * 	- 외부 클래스의 모든 변수(iv, cv), 모든 메소드(im, cm)를 사용할 수 있다
	 */
		
	
	public int value1;
	
	static int value2;
	
	public void method1() {
		
	}
	
	public static void method2() {
		
	}
	
	public Inner1 getInner1() {
		Inner1 inner1 = new Inner1();
		return inner1;
		
	}
	/*
	 * 멤버 내부 클래스
	 * 	- 외부클래스로 객체 생성후 사용가능한 내부 클래스다.
	 * 	- 외부 클래스의 모든 변수(iv, cv)
	 */
	class Inner1 {
		
		public void method() {
			System.out.println(value1);
			System.out.println(value2);
			method1();
			method2();
		}
	}
}
