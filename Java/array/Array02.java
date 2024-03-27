package array;

public class Array02 {
	public static void main(String[] args) {
		
		/*
		 * 배열에 엑세스하기
		 * 	- 배열의 각 저장소에 엑세스는 배열의 인덱스를 이용한다
		 * 
		 * 형식
		 * 	- 배열에 값 저장하기
		 * 		참조변수명[인덱스]	= 값;	
		 * 	- 배열에 저장된 값 사용하기
		 * 		System.out.println(참조변수명[인덱스])
		 * 
		 * 	- 배열의 길이 조회하기
		 * 		참조변수명.length
		 * 		* 배열객체에는 length라는 프로퍼티가 있다.
		 * 		* 프로퍼티는 객체의 구성요소고, 객체의 고유한 값을 저장하고 있다.
		 * 		* 배열의 길이는 변경할 수 없다.
		 */
		
		// new 키워드를 사용해서 빈 배열객체 생성하기
		// 빈 배열객체의 각 저장소는 저장된 타입의 기본값으로 초기화 되어 있다.
		int[] arr1 = new int[3];	// int타입은 0
		double[] arr2 = new double[3];	// double타입은 0.0
		String[] arr3 = new String[3];	// String타입은 null
										// null은 객체를 참조하지 못하게하는 값.
		
		System.out.println("첫번째 배열의 길이 : "+arr1.length);
		System.out.println("두번째 배열의 길이 : "+arr2.length);
		System.out.println("세번째 배열의 길이 : "+arr3.length);
		
		// 배열객체의 0번째 저장소에 값 저장하기
		arr1[0] = 10;
		arr2[0]	= 3.14;
		arr3[0] = "서울";
		
		// 객체의 각 저장소의 값을 확인해보기
		System.out.println(arr1[0]);
		System.out.println(arr1[1]);
		System.out.println(arr1[2]);
		
		System.out.println(arr2[0]);
		System.out.println(arr2[1]);
		System.out.println(arr2[2]);
		
		System.out.println(arr3[0]);
		System.out.println(arr3[1]);
		System.out.println(arr3[2]);
		
	}
}
