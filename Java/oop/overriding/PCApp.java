package overriding;

public class PCApp {
	
	public static void main(String[] args) {
		
		// 다양한 프린터객체를 준비한다.
		Printer p1 = new Printer();
		ColorPrinter p2 = new ColorPrinter();
		PhotoPrinter p3 = new PhotoPrinter();
		
		// 컴퓨터 객체를 준비한다
		PC pc = new PC();
		
		// 컴퓨터 객체와 프린터 객체를 조립한다
		pc.p = p3;
		
		// 문서를 인쇄한다
		pc.printDocument();
	}
}
