package generic;

public class App3 {

	public static void main(String[] args) {
		
		FruitBox<Apple> box1 = new FruitBox<Apple>();
		box1.add(new Apple());
		Apple apple= box1.get();
		
		
//		FruitBox<T extends Fruit>으로 지정했기 때문에 Fruit을 상속받지 않는 타입은 들어오지 못한다
		
//		FruitBox<String> box2 = new FruitBox<>();
//		box2.add("과일장수");
//		String master = box2.get();
		
		FruitBox<Banana> box2 = new FruitBox<Banana>();
		box2.add(new Banana());
		Banana banana = box2.get();
		

	}
}
