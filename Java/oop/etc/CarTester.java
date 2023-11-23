package etc;

public class CarTester {

	public void testCar(Car car) {
		// 운전기능
		car.go();
		car.stop();
		
		// 에어컨기능
		if (car instanceof Aircon) {
			Aircon air = (Aircon) car;
			air.airControl();
		}
		
		// 내비게이션 기능
		if (car instanceof Navigation) {
			Navigation navi = (Navigation) car;
			navi.navi();
		}
	}
	
	public static void main(String[] args) {
		
		Tico tico = new Tico();
		Sonata sonata = new Sonata();
		Sample sample = new Sample();
		
		CarTester tester = new CarTester();
		tester.testCar(tico);
		tester.testCar(sonata);
		//tester.testCar(sample);
		// 오류발생 The method testCar(Car) in the type CarTester is not applicable for the arguments (Sample)
	}
}
