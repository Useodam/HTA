package inheritance;

public class PhoneApp2 {
	
	public static void main(String[] args) {
		// 클래스의 형변환
		// 생성한 객체와 참조변수의 타입이 다를때 발생
		// 실제 생성한 객체와 타입이 맞는 부모객체를 바라보는 것 (자식객체를 부모타입의 참조변수에 대입하는 것)
		// 클래스의 형변환은 자기자신과 부모타입만 해당이 된다
		
		// p2.appleMusic()은 사용할 수 없다
		// 동일하게 아이폰 객체를 만들었지만 바라보는 객체의 주소값에 따라서 사용할 수 있는 기능이 달라진다
		// 클래스 형변환을 사용하는 이유 : 객체의 종류를 제한하기 위해서
		// 다른 이유 : 
		
		// Iphone객체는 Iphone타입이다.
		Iphone p1 = new Iphone();
		p1.appleMusic();				// Iphone 객체
		p1.applePay();					// Iphone 객체
		p1.ip = "108.15.97.5";			// SmartPhone 객체
		p1.internet();					// SmartPhone 객체
		p1.game();						// SmartPhone 객체
		p1.number = "010-1234-1234";	// Phone 객체
		p1.call();						// Phone 객체
		p1.receive();					// Phone 객체
		
		// Iphone 객체는 SmartPhone 타입이다
		SmartPhone p2 = new Iphone();
//		p2.appleMusic();				// Iphone 객체
//		p2.applePay();					// Iphone 객체
		p2.ip = "108.15.97.5";			// SmartPhone 객체
		p2.internet();					// SmartPhone 객체
		p2.game();						// SmartPhone 객체
		p2.number = "010-1234-1234";	// Phone 객체
		p2.call();						// Phone 객체
		p2.receive();					// Phone 객체
		
		// Iphone 객체는 Phone 타입이다.
		Phone p3 = new Iphone();
//		p3.appleMusic();				// Iphone 객체
//		p3.applePay();					// Iphone 객체
//		p3.ip = "108.15.97.5";			// SmartPhone 객체
//		p3.internet();					// SmartPhone 객체
//		p3.game();						// SmartPhone 객체
		p3.number = "010-1234-1234";	// Phone 객체
		p3.call();						// Phone 객체
		p3.receive();					// Phone 객체
	}
}
