package etc;

import java.io.Serializable;

public class SampleApp {
	
	public static void main(String[] args) {
		
		// 객체가 특정 클래스나 특정 인터페이스 타입인지 체크하기
		Sample sample = new Sample();
		
		boolean result1 = sample instanceof Cloneable;
		boolean result2 = sample instanceof Serializable;
		boolean result3 = sample instanceof Comparable;
		
		System.out.println("복제가능 여부 : "+result1);
		System.out.println("직렬화가능 여부 : "+result2);
		System.out.println("정렬가능 여부 : "+result3);
	}
}
