package overriding;

public class ColorPrinter extends Printer {
	
	// Printer 객체의 print() 메소드를 재정의 하였다
	public void print() {
		System.out.println("컬러로 인쇄합니다");
	}
}
