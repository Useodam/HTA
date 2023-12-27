package exception1;

import java.io.FileWriter;
import java.io.IOException;

public class App1 {

	public static void main(String[] args) {

		/*
		 * try ~ catch를 이용한 예외처리
		 * 
		 *  try {
		 *  	예외를 발생시키는 수행문;
		 *  	예외를 발생시키는 수행문;
		 *  } catch(자식예외클래스명 변수명) {
		 *  	예외 발생시 실행할 수행문
		 *  }  catch(부모예외클래스명 변수명) {
		 *  	예외 발생시 실행할 수행문
		 *  }  catch(Exception 변수명) {
		 *  	예외 발생시 실행할 수행문
		 *  }
		 *  
		 *  + catch 블록을 여러 개 작성할 때는 부모타입예외를 잡은 catch 블록을
		 *    아래쪽에 위치시켜야 한다
		 *  + 맨 아래쪽 catch 블록에 Exception 타입을 예외를 잡을 수 있도록
		 *    구성하면 예상하지 못한 예외도 잡을 수 있다
		 *  + 발생이 예상되는 예외들이 부모-자식 관계가 아닐때는 순서와 상관없이
		 *    catch 블록을 구성해도 된다
		 *  + catch 블록에서 선언한 변수는 해당 블록에서만 사용할 수 있다 
		 */
		try {
			// 예외발생이 예상되는 수행문을 작성한다
			FileWriter writer = new FileWriter("sample.txt");
			writer.write("예외처리 연습");
			
			writer.close();
		} catch (IOException e) {
			// 예외발생시 실행할 수행문을 작성한다.
			System.out.println("파일 쓰기 작업 중 오류가 발생하였습니다");
		}
	}
}
