package array;

public class Array04 {
	public static void main(String[] args) {
		/*
		 * 배열과 관련된 오류내용 확인하기
		 * 
		 * 	- 배열의 인덱스 범위를 벗어났을 때
		 * 		int[] arr1 = {10, 20, 30};
		 * 		System.out.println(arr[3]);
		 * 
		 * 		ArrayIndexOutOfBoundsException 예외발생
		 * 
		 * 	- 배열객체를 더이상 참조하지 않고 있는 참조변수로 배열객체를 엑세스했을 때
		 * 
		 */
		
		// 배열의 인덱스 범위를 벗어났을 때
		int[] arr1 = {10, 20, 30};
		System.out.println(arr1[0]);
		System.out.println(arr1[1]);
		System.out.println(arr1[2]);
//		System.out.println(arr1[3]);		예외발생 ArrayIndexOutOfBoundsException가 발생
		/*	Exception in thread "main"			쓰레드 메인에서 예외가 발생했다.
		 * java.lang.ArrayIndexOutOfBoundsException:	오류의 종류 :	배열의 인덱스 범위를 벗어났다
		 * Index 3 out of bounds for length 3			오류의 원인 : 	배열의 길이가 3인데 인덱스를 3이라고 기입해서
		 *	at array.Array04.main(Array04.java:18)		
		 *	오류가 발생한 위치 : array패키지에 Array04클래스에 main메소드(Array04클래스에 18번쩨줄)
		*/
		
		arr1 = null;	// arr1 참조변수는 더이상 배열객체를 참조하지 않는다
		
		if(arr1 != null) {
			System.out.println(arr1.length);
		}
		System.out.println(arr1.length);	// 예외발생 NullPointerException
//		Null pointer access: The variable arr1 can only be null at this location
	}
}
