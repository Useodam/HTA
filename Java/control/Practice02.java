package control;

import java.util.Scanner;

public class Practice02 {
	public static void main(String[] args) {
		
		/*
		 * 	완료시간 출력하기
		 * 
		 * 입력으로 현재 시간의 시간정보와 분 정보를 입력받는다
		 * 입력으로 소유시간을 분단위로 입력받는다
		 * 
		 * 완료시간을 시,분 단위로 출력한다
		 * 
		 * 예)
		 * 시작시점의 hour : 15
		 * 시작시점의 minute : 20
		 * 소요시간(분) : 50
		 * 
		 * 종료시점은? 16시 10분 
		 * 
		 * 종료시점의 시간은 ( 시작싯점의 분 + 소요시간 ) >= 60인 경우 증가된다
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("시작시점의 시간을 입력하시오.");
		int startHours = sc.nextInt();
		
		
		System.out.print("시작시점의 분을 입력하시오.");
		int startMinutes = sc.nextInt();
		
		System.out.print("소요시간을 입력하시오.");
		int runningTime = sc.nextInt();
		
		int endHours =0;
		int endMinutes =0;
		
		// 에상완료시간을 계산하기
		
		if(startMinutes + runningTime > 60) {
			// 총 분값을 계산한다
			int totalMinutes = startMinutes + runningTime;
			// 총 분값을 60으로 나누어서 증가시킬 '시'를 구한다
			int increaseHours = totalMinutes/60;
			
			// 완료시점은 시는 시간시점의 '시' + 증가시킬 '시'
			endHours = startHours + increaseHours;
			// 완료시점의 '분'은 총 분값에서 증가된 '시'만큼의 분값을 제외
			endMinutes = totalMinutes%60;
			
		} else {
			endHours = startHours;
			endMinutes = startMinutes;
		}
		// 완료시간 출력
		System.out.println("완료시간 : "+ endHours + " 시 " + endMinutes + " 분");
		
		sc.close();
	}
}
