package generic;

public class App2 {

	public static void main(String[] args) {
		
		/*
		 * 제네릭이 적용된 Box 클래스
		 * 	- 객체 생성시점에 타입 파라미터에 해당하는 객체의 타입을 지정할 수 있다
		 * 	- 객체 생성시 지정한 타입의 객체만 저장할 수 있다
		 * 	- 지정된 객체를 사용할 때 형변환이 필요없다
		 */
		GenericBox<String> box1 = new GenericBox<String>();
		box1.add("홍길동");
		String value = box1.get();
		
		// new GenericBox<> 타입파라미터 적는 곳을 생략해도 무방하다
		GenericBox<Integer> box2 = new GenericBox<>();
		box2.add(100);
		int value2 = box2.get();
		
	}
}
