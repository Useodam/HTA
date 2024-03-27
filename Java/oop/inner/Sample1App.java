package inner;

import inner.Sample1.Inner1;

public class Sample1App {

	public static void main(String[] args) {
		
		// 외부 클래스로 객체 생성
		Sample1 sample1 = new Sample1();
		
		// 멤버내부 클래스의 객체 획득
		Inner1 inner1 = sample1.getInner1();
		
		// 멤버내부 객체가 제공하는 기능 실행
		inner1.method();
	}
}
