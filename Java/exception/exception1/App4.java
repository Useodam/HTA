package exception1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class App4 {

	public static void main(String[] args) {
		
		/*
		 * 주요 API
		 * 	String getMessage()
		 * 		오류 메시지를 반환한다
		 * 	void printStackTrace()
		 * 		오류 검출을 위한 프로그램 실행 정보를 화면에 출력한다
		 * 
		 */
		
		try {
		Properties prop = new Properties();
		prop.load(new FileReader("config.properties"));
		} catch (FileNotFoundException ex) {
			// getMessage()는 오류메시지를 반환한다
			String errorMessage = ex.getMessage();
			System.out.println("오류메세지: "+errorMessage);
			
			// printStackTrace()는
			// 오류 검출에 필요한 오류 정보(예외클래스명 + 오류메시지)와
			// 프로그램 실행정보를 화면에 출력한다
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
