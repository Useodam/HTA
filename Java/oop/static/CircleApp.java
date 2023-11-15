package static1;

public class CircleApp {
	public static void main(String[] args) {
		
		// 다양한 반지름을 가지는 Circle 객체 생성하기
		// Circle마다 서로 다른 반지름 값을 가진다
		// Circle객체는 종류와 상관없이 같은 원주율값을 가진다
		// 즉, 반지름은 Circle 객체의 고유한 속성이 될 수 있다
		//	   원주율은 Circle 객체의 고유한 속성이 될 수 없다
		//	   반지름은 객체의 고유한 속성이기 때문에 멤버변수로 정의해야한다
		//	   원주율은은 객체의 고유한 속성이 아니기 때문에 멤버변수로 정의해야한다
		Circle c1 = new Circle(1, 3.14);
		Circle c2 = new Circle(3, 3.14);
		Circle c3 = new Circle(5, 3.14);
		Circle c4 = new Circle(7, 3.14);
		
		System.out.println("원의 둘레길이 : "+c1.round());
		System.out.println("원의 둘레길이 : "+c2.round());
		System.out.println("원의 둘레길이 : "+c3.round());
		System.out.println("원의 둘레길이 : "+c4.round());
	}
}
