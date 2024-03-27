package generic;

public class App4 {

	public static void main(String[] args) {

		// box1은 Fruit 객체를 저장하는 박스 객체다
		FruitBox<Fruit> box1 = null;
		
		box1 = new FruitBox<Fruit>();
		
		// 제네릭스 객체의 타입파라미터간에는 형변환이 불가능하다
//		box1 = new FruitBox<Apple>();
//		box1 = new FruitBox<Banana>();

		
	}
}
