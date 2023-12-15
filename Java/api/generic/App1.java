package generic;

import java.util.Date;

public class App1 {

	public static void main(String[] args) {
		
		/*
		 * 제네릭이 적용되지 않은 박스객체
		 * 	- 아무객체나 막 담을 수 있다
		 * 	- 항상 Object 타입으로 꺼내지기 때문에 매번 형변환 해야한다
		 */
		NoneGenericBox box1 = new NoneGenericBox();
		box1.add(100);
		int value1= (Integer)box1.get();
		
		NoneGenericBox box2 = new NoneGenericBox();
		box2.add("홍길동");
		String value2 =(String)box2.get();
		
		NoneGenericBox box3 = new NoneGenericBox();
		box3.add(new Date());
		Date value3 =(Date)box3.get();
		
	}
}
