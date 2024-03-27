package static1;


public class StaticSample {
	
	int x;
	static int y;
	
	public void m1() {
		// 인스턴스 메소드에서는 인스턴스 변수, 클래스 변수를 사용할 수 있다.
		x = 10;
		StaticSample.y = 20;
	}
	
	public void m2() {
		// 인스턴스 메소드에서 인스턴스 메소드, 클래스 메소드를 사용할 수 있다.
		m1();
		StaticSample.m3();
	}
	
	public static void m3() {
		// 클래스 메소드에서는 인스턴스 변수를 사용할 수 없다.
		//		x = 10; 오류
		// 클래스 메소드에서는 클래스 변수를 사용할 수 있다
		StaticSample.y= 20;
	}
	
	public static void m4()	{
		// 클래스 메소드에서는 인스턴스 메소드를 사용할 수 없다
		//		m1(); 오류
		// 클래스 메소드에서는 클래스 메소드를 사용할 수 있다
		StaticSample.m3();
	}
	
}
