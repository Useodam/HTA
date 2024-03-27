package etc;

public class CarTester2 {
	
	public void testCar(Car c) {
		c.go();
		c.stop();
	}
	
	public void testAircon(Aircon a) {
		a.airControl();
	}
	
	public void testNavigation(Navigation n) {
		n.navi();
	}
	
	public static void main(String[] args) {
		Tico t = new Tico();
		Sonata s = new Sonata();
		
		CarTester2 tester2 = new CarTester2();
		
		// 운전기능 테스트
		tester2.testCar(s);
		tester2.testCar(t);
		
		// 에어컨기능 테스트
		tester2.testAircon(t);
		tester2.testAircon(s);
		
		// 내비게이션기능 테스트
//		tester2.testNavigation(t);
//		Tico는 Navigation 인터페이스를 구현하지 않았기 때문에 오류가 발생한다
		tester2.testNavigation(s);
	}
}
