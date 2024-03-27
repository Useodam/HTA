package lang;

public class StringApp6 {

	public static void main(String[] args) {
		
		/*
		 * char indexOf(String str)
		 * 	- 문자열에서 지정된 문자열이 처음으로 등장하는 위치를 반환한다
		 * 	- 지정된 문자열을 찾을 수 없으면 -1을 반환한다
		 * 
		 * int indexOf(String str, int fromIndex)
		 * 	- fromIndex에 지정된 위치부터 문자열을 검색해서 등장위치를 반환한다
		 * 
		 * int lastIndexOf(String str)
		 * 	- 문자열에서 지정된 문자열이 마지막으로 등장하는 위치를 반환한다
		 * 	- 지정된 문자열을 찾을 수 없으면 -1을 반환한다
		 * 
		 * int lastIndexOf(String str, int fromIndex)
		 * 
		 */
		
		String str1 = "02)7894-1234";
		String str2 = "041)1111-9999";
		
		// indexOf(")")는 문자열에서 ")"가 등장하는 위치값(인덱스)를 반환한다.
		String str3 = str1.substring(0, str1.indexOf(")"));
		String str4 = str2.substring(0, str2.indexOf(")"));
		
		System.out.println("국번 : " + str3);
		System.out.println("국번 : " + str4);
		
		
		/*
		 * char charAt(int index)
		 * 	- 문자열에서 지정된 위치의 문자하나를 반환한다
		 */
		
		String str5 = "abcdefg";
		char ch1 = str5.charAt(0);
		char ch2 = str5.charAt(1);
//		char ch3 = str5.charAt(10);			// 실행오류 발생, StringIndexOutOfBoundsException 예외발생
		System.out.println("문자 : "+ ch1);
		System.out.println("문자 : "+ ch2);
//		System.out.println("문자 : "+ ch3);
		
		
		
		
		
		
		
		
		
		
		
	}
}
