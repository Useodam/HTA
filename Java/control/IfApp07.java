package control;

public class IfApp07 {
	public static void main(String[] args) {
		/*
		 * 빠르게 종료하기
		 * 	나쁜 조건이 발견되면 더이상 수행문을 수행하지 않고 해당 위치에서 메소드의 실행을 중단시키는 것이다.
		 * 	return 문은 메소드의 실행을 즉시 중지시킨다
		 * 
		 * 형식
		 * 	if (나쁜조건) {
		 * 		수행문;
		 * 		return;
		 * 	}
		 * 	수행문;	// 나쁜조건이 아닐때만 실행된다.
		 * 
		 * "빠르게 종료하기"를 활용하면 불필요한 검사가 실행되지 않게 한다.
		 * "빠르게 종료하기"를 활용하면 프로그램의 구조를 단순하게 작성할 수 있다.
		 * "빠르게 종료하기"를 활용하면 코드의 가독성을 향상시킬 수 있다.
		 */
		
		int kor = 30;
		int eng = 70;
		int math = 100;
		
		if (kor < 40) {
			System.out.println("불합격(국어과목 과락) : "+ kor);
			return;
		}
		if (eng < 40) {
			System.out.println("불합격(영어과목 과락) : "+ eng);
			return;
		}
		if (math < 40) {
			System.out.println("불합격(수학과목 과락) : "+ math);
			return;
		}
		
		int avg = (kor + eng + math)/3;
		if (avg >= 60) {
			System.out.println("합격입니다");
			
			if(avg >= 96) {
				System.out.println("장학금 지급대상입니다.");
			}
		} else {
			System.out.println("불합격입니다");
		}
	}
}
