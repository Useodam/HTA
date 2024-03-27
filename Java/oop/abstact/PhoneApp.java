package abstraction;

public class PhoneApp {

	public static void main(String[] args) {
		
		// NormalPhone 타입의 참조변수는 NormalPhoner객체를 참조할 수 있다
		NormalPhone p1 = new NormalPhone();
		// Phone타입의 참조변수는  NormalPhone 객체를 참조할 수 있다
		Phone p2 = new NormalPhone();
		// IPhone타입의 참조변수는  IPhone 객체를 참조할 수 있다
		Iphone p3 = new Iphone();
		// SmartPhone타입의 참조변수는  IPhone 객체를 참조할 수 있다
		SmartPhone p4 = new Iphone();
		// Phone타입의 참조변수는  IPhone 객체를 참조할 수 있다
		Phone p5 = new Iphone();
		
		p3.game();		// SmartPhone Interface
		p3.internet();	// SmartPhone Interface
		p3.call("010-1111-2225");	// Phone Interface
		p3.receive();				// Phone Interface
		p3.sms("010-1111-2222", "안녕하세요");	// Phone Interface
		System.out.println();
		
		p4.game();		// SmartPhone Interface
		p4.internet();	// SmartPhone Interface
		System.out.println();
//		p4.call("010-1111-2225");		// Phone Interface
//		p4.receive();					// Phone Interface
//		p4.sms("010-1111-2222", "안녕하세요");	// Phone Interface
//	      
//	    p5.game();		// SmartPhone Interface
//	    p5.internet();	// SmartPhone Interface
	    p5.call("010-1111-2222");		// Phone Interface
	    p5.receive();					// Phone Interface
	    p5.sms("010-1111-2222", "안녕하세요");	// Phone Interface
	    System.out.println();

	}
}
