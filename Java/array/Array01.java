package array;

public class Array01 {
	public static void main(String[] args) {
		
		/*
		 * 배열
		 * 	- 같은 타입의 값을 여러개 연속적으로 저장하는 객체다.
		 * 	- 배열객체의 각 칸에는 0부터 시작하는 인덱스가 자동으로 부여된다.
		 * 	- 자바의 배열은 한 번 정해진 크기를 변경할 수 없다.
		 * 		(배열을 생성할 때 크기를 반드시 지정하거나, 배열에 저장할 값을 구체적으로 나열해야한다.)
		 * 	- 배열객체의 각 칸은 해당 타입의 기본값으로 자동으로 초기화된다.
		 * 
		 * 	배열의 생성
		 * 	
		 * 	- 배열 리터럴을 이용해서 배열객체 생성하기
		 * 		int[] arr1 = {10, 20, 30};
		 * 		double[] arr2 = {10.1, 6.8, 4.2, 7.7};
		 * 		String[] arr3 = {"김","이","박","최"};
		 * 
		 * 	- new 키워드를 이용해서 빈 배열객체 생성하기
		 * 		int []	arr1 = new int[5];
		 * 		double[] arr2 = new double[4];
		 * 		String[] arr3 = new String[3];
		 * 		* 배열의 크기를 생략할 수 없다.
		 * 
		 * 	- new 키워드를 이용해서 값을 가지는 배열객체 생성하기
		 * 		int[] arr1 = new int[]{10, 20, 30}
		 * 		double[] arr2 = new double[]{3.14, 1.59, 3.88};
		 * 		String [] arr3 = new String[]{"서울", "수원", "대구"};
		 */
		
		// 배열 리터럴로 배열객체 생성하기
		int[] arr1 = {10, 30, 70, 20};
		String[] arr2 = {"서울", "대전", "대구"};
		
		// new 키워드로 배열객체 생성하기	- 빈 배열 객체를 생성한다.
		int [] arr3 = new int[3];		// 정수 3개 저장할 수 있는 배열객체를 생성하고,
										// 그 배열객체의 주소값을 arr3에 대입시킨다.
		
		double [] arr4 = new double[4];	// 실수 4개를 저장할 수 있는 배열객체를 생성하고,
										// 그 배열객체의 주소값을 arr4에 대입시킨다.
		
		String [] arr5 = new String[3];
		
		System.out.println("첫번째 배열객체 : "+arr1);
		// 첫번째 배열객체 : [I@5acf9800  <-- 해시코드 값
		System.out.println("첫번째 배열객체 : "+arr2);
	}
}
