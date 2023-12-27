package exception1;

public class App5 {

	public static void main(String[] args) {
		
		int x = 10;
		int y = 0;
		/*
		 *  ArithmeticException
		 *  - 어떤 숫자를 0으로 나눌때 발생하는 예외다
		 *  - UncheckedException이다. (컴파일러가 예외처리 여부를 체크하지 않는다)
		 *  - 나눗셈 연산은 ArithmeticException 예외가 발생할 가능성이 있는 수행문이다
		 *  - ArithmeticException 예외가 UncheckedException 이기 때문에
		 *    나눗셈 연산식에 대해서 예외처리 코드를 작성할 필요가 없다 		
		 */
		int z = x/y;
		
		System.out.println("연산결과 : " + z);
	}
}
