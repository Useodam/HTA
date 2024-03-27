package time;

import java.time.LocalDate;

public class App2 {

	public static void main(String[] args) {
		
		// 날짜에 특정 기간을 적용하기
		
		LocalDate date1 = LocalDate.now().plusDays(10);
		LocalDate date2 = LocalDate.now().plusWeeks(5);
		LocalDate date3 = LocalDate.now().plusMonths(6);
		System.out.println("10일 후 :" +date1);
		System.out.println("5주 후 :"+date2);
		System.out.println("6개월 후 :"+date3);
		
		LocalDate date4 = LocalDate.now().minusDays(10);
		LocalDate date5 = LocalDate.now().minusWeeks(5);
		LocalDate date6 = LocalDate.now().minusMonths(6);
		System.out.println("10일 전 :" +date4);
		System.out.println("5주 전 :"+date5);
		System.out.println("6개월 전 :"+date6);
	}
}
