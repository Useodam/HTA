package time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class App3 {

	public static void main(String[] args) {
		
		// 두 날짜 사이의 기간을 조회하기
		LocalDate today = LocalDate.now();
		LocalDate birthDay = LocalDate.of(1997, 2, 12);
		
		long years = ChronoUnit.YEARS.between(birthDay, today);
		long months = ChronoUnit.MONTHS.between(birthDay, today);
		long days = ChronoUnit.DAYS.between(birthDay, today);
		
		System.out.println("년수 : "+ years);
		System.out.println("개월수 : "+ months);
		System.out.println("일수 : "+ days);
	}
}
