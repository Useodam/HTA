package collection;

import java.io.FileReader;
import java.text.MessageFormat;
import java.util.Properties;

public class PropertiesApp2 {

	public static void main(String[] args) throws Exception{
		
		/*
		 * MessageFormat
		 * 	- 사용자에게 표시될 메시지를 생성하는 클래스다
		 * 	- 지정된 문자열을 텍스트 패턴의 적절한 위치에 삽입시킨다.
		 * 	  MessageFormat.format("{0}님 안녕하세요. 고객님의 등급은 {1}입니다", name, grade);
		 * 	- 주요 메소드
		 * 		String MessageFormat.format(String pattern, Object... args)
		 * 			- 패턴 문자열의 지정된 위치에 값을 삽입시킨 문자열을 반환한다.
		 */
		
		Properties prop = new Properties();
		prop.load(new FileReader("src/collection/config.properties"));
		
		
		String grade = "gold";
		int orderPrice = 20_0000;
		
		String key = MessageFormat.format("customer.{0}.depositrate", grade);
		String value = prop.getProperty(key);
		double depositRate = Double.parseDouble(value);
		
		int point = (int) (orderPrice*depositRate);
		
		System.out.println("적립포인트 : "+point);
		
	}
}
