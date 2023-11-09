package control;

public class SwitchApp01 {
	public static void main(String[] args) {
		
		/*
		 * switch 문
		 * 
		 * 형식
		 * 		switch (값) {
		 * 			case 값1:	// 값이 값1과 일치하면 아래의 수행문이 실행된다.
		 * 				수행문;
		 * 				수행문;
		 * 				break;
		 * 			case 값2:	// 값이 값2와 일치하면 아래의 수행문이 실행된다
		 * 				수행문;
		 * 				수행문;
		 * 				break;
		 * 			case 값3:	// 값이 값3과 일치하면 아래의 수행문이 실행된다.
		 * 				수행문;
		 * 				수행문;
		 * 				break;
		 * 			default :	// 값이 값1, 값2, 값3 모두와 일치하지 않으면 아래의 수행문이 실행된다.
		 * 				수행문;
		 * 				수행문;
		 *		} 
		 *
		 *	java7부터 값의 타입으로 String이 사용가능해졌다.(이전 버전에는 정수, 문자만 가능)
		 *	switch문은 값에 대한 범위비교가 불가능하다.
		 *	case문에서 break를 생략하면, 해당 case가 실행되고 난 후 다음 case도 실행된다.
		 *	switch문은 범주형 데이터의 값을 비교할 때 활용된다.
		 *	(범주형 데이터의 예
		 *		성별 : 남자, 여자
		 *		고객등급 : 골드, 실버, 브론즈, 언랭
		 *		주문상태 : 결재완료, 상품준비중, 상품배달중, 배송완료)
		 */
		
		// 고객 등급별 구매금액에 대한 포인트 계산
		// 골드등급은 구매금액의 5%를 포인트로 적립한다
		// 실버등급은 구매금액의 2%를 포인트로 적립한다.
		// 브론즈등급은 구매금액의 1%를 포인트로 적립한다.
		
		String customerGrade = "실버";
		int orderPrice = 1_000_000;
		int point = 0;
		
		switch (customerGrade) {
		case "골드" :
			System.out.println("골드 등급에 대한 포인트 계산");
			point = (int)(orderPrice*0.05);
			break;
		case "실버" :
			System.out.println("실버 등급에 대한 포인트 계산");
			point = (int)(orderPrice*0.02);
			break;
		case "브론즈" :
			System.out.println("브론즈 등급에 대한 포인트 계산");
			point = (int)(orderPrice*0.01);
			break;
		}
		
		System.out.println("적립 포인트 : "+point);
		
	}
}
