package lang;

import java.util.Map;
import java.util.Properties;

public class SystemApp1 {

	public static void main(String[] args) {
		
		/*
		 * long currentTimeMillis()
		 * 	- 컴퓨터의 유닉스타임값을 반환한다
		 * 	- 유닉스타임은 1970년 1월 1일 0시0분0초부터 
		 * 	  현재까지의 시간을 1/1000초 단위로 표현한 값
		 */
		long unixtime = System.currentTimeMillis();
		System.out.println("유닉스타임 : " + unixtime);
		
		/*
		 * String getProperty(String name)
		 * 	
		 */
		String value1 = System.getProperty("user.language");
		String value2 = System.getProperty("user.country");
		String value3 = System.getProperty("user.name");
		String value4 = System.getProperty("user.home");
		String value5 = System.getProperty("user.dir");
		String value6 = System.getenv("line.separator");
		String value7 = System.getenv("file.separator");
		
		System.out.println("언어 : " + value1);
		System.out.println("국가 : " + value2);
		System.out.println("사용자이름 : " + value3);
		System.out.println("사용자의 홈 디렉토리 경로 : " + value4);
		System.out.println("현재 디렉토리 : " + value5);
		System.out.println("시스템의 줄바꿈 문자 : " + value6);
		System.out.println("시스템의 디렉토리구분 문자 : " + value7);
		
		/*
		 * String getenv(String name)
		 * 	- 지정된 이름에 해당하는 시스템의 환경변수값을 반환한다
		 */
		String env1 = System.getenv("JAVA_HOME");
		String env2 = System.getenv("PATH");
		String env3 = System.getenv("TEMP");
		
		System.out.println("자바 홈 디렉토리 : "+ env1);
		System.out.println("path 디렉토리 : "+ env2);
		System.out.println("임시 디렉토리 경로 : "+ env3);
	}
}
