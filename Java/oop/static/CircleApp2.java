package static1;

public class CircleApp2 {
	public static void main(String[] args) {
		
		Circle2 c1 = new Circle2(1);
		Circle2 c2 = new Circle2(3);
		Circle2 c3 = new Circle2(5);
		Circle2 c4 = new Circle2(7);
		
		System.out.println("원의 둘레길이 : "+c1.round());
		System.out.println("원의 둘레길이 : "+c2.round());
		System.out.println("원의 둘레길이 : "+c3.round());
		System.out.println("원의 둘레길이 : "+c4.round());
	}
}
