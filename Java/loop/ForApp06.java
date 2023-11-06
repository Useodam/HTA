package loop;

public class ForApp06 {
	public static void main(String[] args) {
		/*
		 * break와 continue
		 * 	- break와 continue는 반복문 내에만 사용할 수 있는 키워드다.
		 * 		(break와 switch에서 사용가능하다.)
		 * 	- break는 이 키워드가 포함된 가장 안쪽 반복문을 탈출한다
		 * 	- continue는 반복이 진행중에 continue를 만나면 반복문의 끝
		 * 		(for는 증감식, while은 조건식으로 이동)으로 이동해서
		 * 		다음 번 반복으로 넘어간다
		 * 
		 * 
		 * 		
		 * 	예)
		 * 		for (초기식; 조건식; 증감식) {
		 * 			수행문;
		 * 			수행문;
		 * 
		 * 			// break는 주로 if문과 함께 사용되어
		 * 			// 특정 조건을 만족하면 반복문을 탈출한다
		 * 			if (탈출조건) {
		 * 				수행문;
		 * 				break; ---------|
		 * 			}					|
		 * 		}						|
		 * <____________________________|
		 *		
		 *		// continue는 반복문 내에서만 사용할 수 있고,
		 *		// break와 마찬가지로 if문과 함께 사용되면
		 *		// 다음 번 반복을 하기위해 증감식으로 이동한다.
		 *		for (초기식; 조건식; 증감식) { <----
		 *			수행문;							|
		 *											|
		 *			if (조건식2) {					|
		 *				수행문;						|
		 *				continue;	----------------|		
		 *			}
		 *			
		 *			수행문;
		 *			수행문;
		 *		}
		 *
		 *	이름있는 반복문
		 *		여러 반복문이 중첩되어 있을 때 반복문 앞에 이름을 붙이고,
		 *		break문과 continue문에서 이름을 지정해 줌으로써 
		 *		하나 이상의 반복문을 벗어나거나 반복을 건너뛸 수 있게 한다.
		 *
		 *		형식
		 *			Loop1 : for (초기식; 조건식; 증감식) {
		 *						for (초기식; 조건식; 증감식) {
		 *							수행문;
		 *							if (탈출조건1) {
		 *								break Loop1;
		 *							}
		 *
		 *							if (탈출조건1) {
		 *							 	break;
		 *							}
		 *						} 안쪽 for문의 끝
		 *						수행문;
		 *					}	// 이름이 Loop1인 for문의 끝
		 *			수행문;
		 */
		
		// 1~100까지 순서대로 저장해서 합계를 구할 때 합계가 1000을 
		//	돌파하는 순간의 합계와 그 순간의 숫자값을 출력하기
		
		int sum = 0;
		int number = 0;
		
		for (int num=1; num<=100; num++) {
			sum += num;
			
			if(sum >=1000) {
				number = num;
				break;
			}
		}
		
		System.out.println("합계 : "+sum);
		System.out.println("숫자 : "+number);
		
	}
}
