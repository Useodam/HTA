package array;

public class Array03 {
	public static void main(String[] args) {
		
		/*
		 * 배열 객체의 활용
		 * 	- 배열객체의 생성 목적은 같은 종류와 같은  타입의 값들을 
		 * 	  하나의 이름으로 관리할 수 있다.
		 * 	- 인덱스를 활용해서 배열의 각 저장소를 쉽게 엑세스할 수 있다
		 * 
		 * 	  지역이름
		 * 		String name1 = "서울";
		 * 		String name2 = "대전";
		 * 		String name3 = "대구";
		 * 		String name4 = "부산";
		 * 		
		 * 		String[] names = {"서울", "대전", "대구", "부산"};
		 * 
		 * 		지역이름 출력하기
		 * 			System.out.println(name1);
		 * 			System.out.println(name2);
		 * 			System.out.println(name3);
		 * 			System.out.println(name4);
		 * 
		 * 		for (int index=0; index<3; index++) {
		 * 			System.out.println(names[index]);
		 * 			}
		 */
		
		/*
		 * 	국어점수, 영어점수, 수학점수가 저장된 배열이 각각 있다.
		 * 	국어점수의 평균, 영어점수의 평균, 수학점수의 평균을 계산해서 출력하기 
		 */
		
		int[] korScores = {80, 80, 90, 70, 30, 50};
		int[] engScores = {100, 70, 60, 50, 40, 80};
		int[] mathScores = {90, 70, 40, 80, 100, 70};
		
		// 합계를 계산하기
		int korTotal = 0;
		int engTotal = 0;
		int mathTotal = 0;
		
//		for (int index=0; index<korScores.length; index++) {
//			korTotal += korScores[index];
//		}
//		
//		for (int index=0; index<engScores.length; index++) {
//			engTotal += engScores[index];
//		}
//		
//		for (int index=0; index<mathScores.length; index++) {
//			mathTotal += mathScores[index];
//		}
		
		// 향상된 for문을 사용해서 출력해보기
		for (int value : korScores) {
			korTotal += value;
		}
		
		for (int value : engScores) {
			engTotal += value;
		}
		
		for (int value : mathScores) {
			mathTotal += value;
		}
		
		// 평균을 계산하기
		int korAvg = korTotal/korScores.length;
		int engAvg = engTotal/engScores.length;
		int mathAvg = mathTotal/mathScores.length;
		
		System.out.println("국어점수 평균 : "+ korAvg); 
		System.out.println("영어점수 평균 : "+ engAvg); 
		System.out.println("수학점수 평균 : "+ mathAvg); 
	}
}
