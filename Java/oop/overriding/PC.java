package overriding;

public class PC {
	
	// Printer 객체 및 하위클래스 객체들을 연결하겠다는 의미로 받아들이면 쉽다
	Printer p;
	
	public void printDocument() {
		p.print();
	}
}
