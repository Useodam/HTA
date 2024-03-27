package time;


import java.time.LocalDateTime;
import static java.time.format.DateTimeFormatter.ofPattern;;
/*
 * static import
 * 	- 정적 메소드, 정적 변수를 import 시키는 구문
 * 	- Java 1.5버전부터 지원함.
 */

public class App4 {

	public static void main(String[] args) {
		
		// 문자열로 변환하기
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		String text = now.format(ofPattern("yyyy-MM-dd"));
		System.out.println(text);
		
//		import문에 static을 붙이면 앞에 DateTimeFormatter.를 생략할 수 있다
//		String text = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		String text2 = now.format(ofPattern("M월 d일 EEEE"));
		System.out.println(text2);
	}
}
