package control;

public class IfApp05 {
	public static void main(String[] args) {
		/*
		 * 내포된 if문
		 * 
		 * 형식
		 * 		if (조건식1) {
		 * 			수행문;
		 * 
		 * 			// 조건식2는 조건식1이 true로 판정되는 경우에만 검사가 진행된다.
		 * 			// 내포된 if문을 작성함으로써 해당 조건식이 검사되는 경우를 절약할 수 있다. 
		 * 			if (조건식2) {
		 * 				수행문;
		 * 			} else {
		 * 				수행문;
		 * 
		 * 				if (조건식3) {
		 * 					수행문;
		 * 				} else {
		 * 					수행문;
		 * 				}
		 * 			}
		 * 		}
		 * if 블록이나 else 블록 내부에 포함된 if문 혹은 if~else문이라고 말한다.
		 */
		
		// 장학금 지급하기
		// 장학금은 시험 합격자 중에서 평균점수가 96점 이상인 경우 장학금 지급대상이 된다.
		// 평균점수가 60점 이상이면 합격, 그 외는 불합격이다.
		
		int kor = 95;
		int eng = 98;
		int math = 97;
		
		int avg = (kor + eng + math)/3;
		
		if (avg >=60 ) {
			System.out.println("합격입니다.");
			
			if (avg >= 96) {
				System.out.println("장학금 지급대상입니다.");
			}
		} else {
			System.out.println("불합격입니다.");
		}
	}
}
