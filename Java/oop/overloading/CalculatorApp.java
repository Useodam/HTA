package overloading;

public class CalculatorApp {
	public static void main(String[] args) {
		
		Calculator c = new Calculator();
		
		int result1 = c.sum(10, 20);
		int result2 = c.sum(10, 20, 40);
		
		System.out.println("첫번째 실행결과 : "+result1);
		System.out.println("두번째 실행결과 : "+result2);
	}
}
