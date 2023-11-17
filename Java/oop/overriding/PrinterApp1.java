package overriding;

public class PrinterApp1 {

	public static void main(String[] args) {
		
		Printer p1 = new Printer();
		p1.print();	// Printer 객체의 print()가 실행됨
		
		ColorPrinter p2 = new ColorPrinter();
		p2.print();	// ColorPrinter 객체의 재정의된 print()가 실행됨
		
		Printer p3 = new ColorPrinter();
		p3.print();	// ColorPrinter의 재정의된 print()가 실행됨
					// Printer 객체를 참조하고 있어도 실제 생성한
					// ColorPrinter 객체의 재정의된 print()가 실행된다
					// 즉, Printer 타입의 참조변수로 자식 Printer 객체를 참조하고 있을 때
					// print()를 실행하면 실제 생성된 객체에 재정의된 print()가 실행된다
		
	}
}
