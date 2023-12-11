package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateApp2 {

	public static void main(String[] args) {
		
		/*
		 * 날짜와 시간정보를 지정된 포맷형식의 텍스트로 변환하기
		 * 
		 * SimpleDateFormat
		 * 	- Date객체의 날짜와 시간정보를 지정된 포맷의 텍스트로 변환한다
		 * 	- 주요 메소드
		 * 		생성자
		 * 			SimpleDateFormat(String pattern)
		 * 			- 지정된 패턴으로 날짜와 텍스트간의 변환을 지원하는 객체를 생성한다
		 * 		멤버 메소드
		 * 			String format(Date date)
		 * 			 - Date객체의 날짜와 시간정보를 생성자에게 지정한 패턴에 맞는
		 * 			   포맷형식의 텍스트로 변환해서 반환한다
		 * 			Date parse(String text)
		 * 			 - 텍스트가 생성자에서 지정한 형식으로 작성된 날짜와 시간정보라면
		 * 			   텍스트에 해당하는 날짜와 시간정보를 가진 Date객체로 변환해서 반환한다.	
		 */
		
		Date now = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd");
		String text = sdf.format(now);
		
		System.out.println(text);	// 2023-11-15
		
		sdf.applyPattern("yyyy-M-d");
		String text2 = sdf.format(now);
		System.out.println(text2);	// 2023-11-15
		
		sdf.applyPattern("yyyy년 M월 d일");
		String text3 = sdf.format(now);
		System.out.println(text3);	// 2023년 11월 15일
		
		sdf.applyPattern("M월 d일 E");
		String text4 = sdf.format(now);
		System.out.println(text4);	// 11월 15일 수
		
		sdf.applyPattern("M월 d일 EEEE");
		String text5 = sdf.format(now);
		System.out.println(text5);	// 11월 15일 수요일
		
		sdf.applyPattern("HH:mm:ss");
		String text6 = sdf.format(now);
		System.out.println(text6);	// 15:27:56
		
		sdf.applyPattern("hh:mm:ss");
		String text7 = sdf.format(now);
		System.out.println(text7);	// 03:29:18
		
		sdf.applyPattern("a h시 m분 s초");
		String text8 = sdf.format(now);
		System.out.println(text8);	// 오후 3시 31분 5초
		
		sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
		String text9 = sdf.format(now);
		System.out.println(text9);	// 2023-11-15 15:33:26
		
		String text10 = DateUtils.dateToString(now);
		System.out.println(text10);
		
		String textDetail = DateUtils.dateToDetailString(now);
		System.out.println(textDetail);
	}
}
