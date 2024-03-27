package modifier.p4;

import modifier.p3.Sample3;

public class Sample3Child extends Sample3{

	Sample3 sample3 = new Sample3();
	
	public void method() {
		// private 접근제한이 적용된 value1은 접근할 수 없다
//		value1 = 10;	컴파일 오류
		
		// 디폴트 접근제한이 적용된 value2은 접근할 수 없다
//		value2 = 20;	컴파일 오류
		
		// protected 접근제한이 적용된 value3은 접근할 수 있다
		value3 = 30;
		
		// public 접근제한이 적용된 value4은 접근할 수 있다
		value4 = 40;
	}
}
