package control;

public class IfApp04_2 {
	public static void main(String[] args) {

		// 구매금액에 따른 적립포인트 계산하기
		// 구매금액이 100만원 이상일 때 5% 적립
		//				50만원 이상일 때 2% 적립
		// 				30만원 이상일 때 1% 적립
		// 				10만원 이상일 때 0.3% 적립
		// 				그 외는 0.1%로 적립
		
		int orderPrice = 1_000_000;	// 구매금액
		int point = 0;				// 적립포인트
		double depositRate = 0.01;
		
		if (orderPrice >= 1_000_000) {
			depositRate = 0.05;
		} else if (orderPrice >= 500_000) {
			depositRate = 0.02;
		} else if(orderPrice >= 300_000) {
			depositRate = 0.01;
		} else if(orderPrice >= 100_000) {
			depositRate = 0.003;
		} 
		
		point = (int)(orderPrice*depositRate);
		
		System.out.println("구매금액 : "+orderPrice);
		System.out.println("적립포인트 : "+point);
	}
}
