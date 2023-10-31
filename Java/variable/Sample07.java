package variable;

public class Sample07 {
	public static void main(String[] args) {
		
		/*
		 * 자바의 연산원칙
		 * 	자바의 연산은 같은 타입끼리만 가능하다.
		 * 	자바의 연산은 연산에 참여한 값의 타입과 연산결과가 항상 동일한 타입이다.
		 * 	자바의 연산에 참여하는 값의 타입이 서로 다른 경우, 같은 타입으로 변환 후 연산이 일어난다.
		 * 	(타입의 변환은 값의 손실이 발생하지 않는 방향으로 이루어진다.)
		 * 	(값의 손실이 일어나지 않는 방향
		 * 		1. 크기가 작은 타입 -> 크기가 더 큰 타입
		 * 			long x = 10;	int타입 10이 long타입 10으로 변환 후 대입
		 * 		2. 정밀도가 낮은 타입 -> 정밀도가 더 높은 타입
		 * 			double x = 3;	int타입 3이 double타입 3.0으로 변환 후 대입된다.
		 * 
		 *	)
		 * 	
		 * 기본 자료형의 형변환
		 * 
		 * 		자동형변환
		 * 			데이터의 손실이 발생하지 않는 방향으로의 형변환은 컴파일러가 자동으로 처리한다.
		 * 		강제형변환
		 * 			데이터의 손실이 발생하는 방향으로의 형변환은 자동으로 일어나지 않기 때문에,
		 * 			개발자가 강제로 형변환 방향을 지정하는 것이다.
		 */
		
		// 연산에 참여한 값의 타입과 연산결과는 동일하다.
		// 정수/정수 --> 정수,	실수/실수 --> 실수
		System.out.println(10/3);
		System.out.println(10.0/3.0);
		
		// 연산에 참여한 값의 타입이 서로 다른 경우, 같은 타입으로 변환 후 연산이 일어난다.
		// 형변환 방향은 더 큰 데이터 타입 혹은 정밀도가 더 높은 타입으로 변환된다.
		// 정수/실수 --> 실수	실수/실수 --> 실수
		System.out.println(12/5.0);	// 12/5.0 --> 12.0/5.0 ---->  2.4
		System.out.println(12.0/5);	// 12.0/5 --> 12.0/5.0 ---->  2.4
		
		// 연산에 참여하는 변수의 타입과 값의 타입이 서로 다른 경우,
		// 값의 타입을 변수의 타입과 같은 타입으로 변환 후 연산이 일어난다.
		double num1 = 3;	// double num1 = 3.0 <-- 3;
		System.out.println(num1);
		
		// 변수의 타입이 int, 값의 타입이 double이다.
		// 변수의 타입과 같은 타입으로 값을 변환하면 데이터의 손실이 발생한다.
		// 따라서, 아래의 대입연산은 자동형변환이 일어날 수 없기 때문에, 오류다.
//		int num2 = 3.14;
		
		// 강제 형변환
		int num3 = (int)3.14;
		System.out.println("num3 : "+num3);
		
		
		// 강제 형변환
		int kor = 80;
		int eng = 70;
		int math = 70;
		int subjectCount = 3;
		int total = kor + eng + math;
		double avg1 = (double)total/subjectCount;	// (double)220/3 -> 220.0/3 -> 220.0/3.0 -> 73.3333
		double avg2 = (double) (total/subjectCount);	// (double)(220/3) -> (double)73 -> 73.0
		System.out.println("평균점수 : "+avg1);	// 73.3333
		System.out.println("평균점수 : "+avg2);	// 73.0
		
		
	}
}
