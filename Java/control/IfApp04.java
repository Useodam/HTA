package control;

public class IfApp04 {
	public static void main(String[] args) {

		// 구매금액에 따른 적립포인트 계산하기
		// 구매금액이 100만원 이상일 때 5% 적립
		//				50만원 이상일 때 2% 적립
		// 				30만원 이상일 때 1% 적립
		// 				10만원 이상일 때 0.3% 적립
		
		int orderPrice = 1_200_000;	// 구매금액
		int point = 0;				// 적립포인트
		
		if (orderPrice >= 1_000_000) {
			point = (int)(orderPrice * 0.05);
		} else if (orderPrice >= 500_000) {
			point = (int)(orderPrice * 0.02);
		} else if(orderPrice >= 300_000) {
			point = (int)(orderPrice * 0.01);
		} else if(orderPrice >= 100_000) {
			point = (int)(orderPrice * 0.003);
		}
		
		System.out.println("구매금액 : "+orderPrice);
		System.out.println("적립포인트 : "+point);
	}
}
