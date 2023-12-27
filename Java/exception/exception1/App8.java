package exception1;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class App8 {
	
	/*
	 * try ~ catch ~ resource 블록
	 *	- try 블록에 자원객체를 전달하면, try 블록이 끝나면 자동으로 자원을
	 *	  반납하는 기능이 지원되는 블록이다
	 *
	 *	try (SomeResource resource = new SomeResource()) {
	 *		resource.method();
	 *		resource.method();
	 *	} catch ( ) {
	 *
	 *	}
	 *	
	 *	try (SomeResource1 resource1 = new SomeResource1();
	 *		 SomeResource2 resource2 = new SomeResource2() ) {
	 *		resource.method();
	 *		resource.method();		
	 *	} catch () {
	 *
	 *	}
	 *
	 *	+ AutoCloseable 인터페이스를 구현한 클래스는 try ~ catch ~ resource 블록을
	 *	  사용하면 사용했던 자원을 자동으로 반납처리한다
	 */

	public static void main(String[] args) {
		
		try (FileWriter writer = new FileWriter("app8.txt")){
			writer.write("자동 반납 연습");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
