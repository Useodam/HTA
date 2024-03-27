package generic;

public class App5 {

	public static void main(String[] args) {
		/*
		 *  와일드카드
		 *  Box<?> : 제한없음
		 *  	타입 파라미터의 구체적인 타입으로 모든 클래스, 모든 인터페이스 타입이 가능하다
		 *  
		 *  Box<? extends X > : 상위 클래스 제한(X포함 X를 상속받은 자식들만)
		 *  	타입 파라미터의 구체적인 타입으로 상위타입 혹은 지정된 상위타입의 하위타입만 가능하다
		 *  
		 *  Box<? super x> : 하위 클래스 제한(x포함 x의 조상들만)
		 *  	타입 파라미터의 구체적인 타입으로 하위타입 혹은 지정된 하위타입의 상위타입만 가능하다
		 *   
		 */
		
		FruitBox<? extends Fruit> box1;
		
		box1 = new FruitBox<Apple>();
		box1 = new FruitBox<Banana>();
		box1 = new FruitBox<Fruit>();

	
	}
}
