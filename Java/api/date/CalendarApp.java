package date;


import java.util.Calendar;
import java.util.Date;

public class CalendarApp {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
//		System.out.println(cal);
		
		cal.set(Calendar.MONTH, 2); // 월을 3월로 지정
		/*
		 * int get(int Calendar.상수)
		 * 	- Calendar 객체에서 field에 해당하는 정보를 반환한다
		 * 
		 * void set(int field, int value)
		 * 	- Calendar 객체에서 지정된 field에 해당하는 정보를 변경한다
		 */
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minutes = cal.get(Calendar.MINUTE);
		int seconds = cal.get(Calendar.SECOND);
		
		System.out.println("년 : "+ year);
		System.out.println("월 : "+ month);
		System.out.println("일 : "+ day);
		System.out.println("시 : "+ hour);
		System.out.println("분 : "+ minutes);
		System.out.println("초 : "+ seconds);
		
		Date date = cal.getTime();
	}
}
