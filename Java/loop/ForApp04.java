package loop;

public class ForApp04 {
	public static void main(String[] args) {
		
		/*
		 * 
		 * 중첩된 for문
		 * 
		 * 형식
		 * 	for (초기식; 조건식; 증감식) {
		 * 		수행문1;
		 * 
		 * 		for (초기식; 조건식; 증감식) {
		 * 			수행문2;
		 * 		}
		 * 	}
		 * 	수행문1은 바깥쪽 for문이 반복 횟수만큼 실행된다.
		 * 	수행문1에서는 안쪽 for문의 초기식에서 생성한 변수를 접근할 수 없다.
		 * 
		 *	수행문2는 바깥쪽 for문이 한 번 실행될 때마다 안쪽 for문의 반복 횟수 만큼 실행된다.
		 *	수행문2에서는 바깥 for문의 초기식에서 생성한 변수,
		 *				  안쪽 for문의 초기식에서 생성한 변수에 접근할 수 있다.
		 * 	
		 * 별찍기
		 * 
		 * *
		 * **
		 * ***
		 * ****
		 * *****
		 * 
		 * *****
		 * ****
		 * ***
		 * **
		 * *
		 * 
		 *     *
		 *    **
		 *   ***
		 *  ****
		 * ***** 
		 * 
		 */
		
		// 정방향 별찍기
		/*			행	열
		 * *****	1	5
		 * *****	2	5
		 * *****	3	5
		 * *****	4	5
		 * *****	5	5
		 */
		
		for (int line = 1; line <=5; line++) {		// 행을 출력
			
			for (int count=1; count<=5; count++) {		// 각 행에 별을 출력
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		// 별 찍기
		/*			행 별갯수
		 * *		1	1
		 * **		2	2
		 * ***		3	3
		 * ****		4	4
		 * *****	5	5
		 */
		
		for (int i=1; i<=5; i++) {
			for(int y=1; y<=i; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		// 별 찍기
		/*			행 별갯수
		 * *****	1	5
		 * ****		2	4
		 * ***		3	3
		 * **		2	2
		 * *		1	1
		 */
		for (int i=5; i>=1; i--) {
			for(int y=1; y<=i; y++) {
				System.out.printf("*");
			}
			System.out.println();
		}
		
		// 별 찍기
		/*			행	공백갯수	별갯수
		 *     *	1	4			1
		 *    **	2	3			2
		 *   ***	3	2			3
		 *  ****	4	1			4
		 * ***** 	5	0			5	
		 * 
		 */
		
		for (int i=1; i<=5; i++) {
			// 공백 찍기
			for(int y=1; y<=5-i; y++) {
				System.out.print(" ");
			}
			// 별 찍기
			for (int z=1; z<=i; z++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
