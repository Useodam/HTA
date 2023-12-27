package exception1;

import java.io.FileWriter;
import java.io.IOException;

public class App3 {
	
	/*
	 * throws 키워드를 사용해서 예외처리 위임하기
	 * 
	 * public void 메소드() throws 예외클래스명, 예외클래스명, 예외클래스명 {
	 * 		예외발생이 예상되는 수행문;
	 * 		예외발생이 예상되는 수행문;
	 * 
	 * }
	 * 
	 * + 메소드내에서 발생되는 예외를 직접처리하지 않고, 이 메소드를 호출하는 측에게
	 * 	 예외를 전달한다
	 * + throws 키워드 뒤에 예외클래스를 쉼표로 구분해서 나열하면 된다
	 */

	public static void main(String[] args) {
		try {
			first();
		} catch (IOException ex) {
			System.out.println(ex);
			System.out.println("입출력 작업 중 오류가 발생하였습니다");
		}
	}
	
	public static void first() throws IOException{
		second();
	}
	
	public static void second() throws IOException{
		
		FileWriter writer = new FileWriter("app3.txt");
		writer.write("예외처리 위임하기");
		writer.close();
	}
}
