package inheritance;

public class PhoneApp {
	
	public static void main(String[] args) {
		
		// Phone객체 생성
		Phone p1 = new Phone();
		p1.number = "010-1234-4567";
		p1.call();
		p1.receive();
		
		// SmartPhone객체 생성
		SmartPhone p2 = new SmartPhone();
		p2.number = "010-7890-1234";
		p2.ip = "182.108.95.3";
		p2.call();
		p2.receive();
		p2.internet();
		p2.game();
	
	}
}
