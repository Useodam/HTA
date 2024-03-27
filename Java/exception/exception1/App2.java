package exception1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class App2 {

	public static void main(String[] args) {
		
		/*
		 * FileNotFoundException
		 * 	- 지정된 경로에 해당하는 파일을 찾을 수 없을 때 던져지는 예외다
		 * IOException
		 * 	- 입출력 작업 중 오류가 발생했을 때 던져지는 예외
		 */
		
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("config.properties"));
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
			System.out.println("파일을 찾을 수 없습니다");
		} catch (IOException ex) {
			System.out.println(ex);
			System.out.println("파일 읽기 작업 중 오류가 발생하였습니다");
		}
	}
}
