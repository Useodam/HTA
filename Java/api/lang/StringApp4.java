package lang;

public class StringApp4 {

	public static void main(String[] args) {
		
		/*
		 * String substring(int beginIndex)
		 * 	- 지정된 시작위치 ~ 문자열 끝 범위에 해당하는 문자열로 구성된 새 문자열을 반환한다
		 * 	  단, 문자열의 인덱스는 0부터 시작한다
		 * 	- beginIndex는 포함된다
		 * 
		 * String substring(int beginIndex, ind endIndex)
		 * 	- 지정된 시작위치 ~ 끝위치 범위에 해당하는 문자열로 구성된 새 문자열을 반환한다
		 * 	- beginIndex는 포함, endIndex는 포함되지 않는다
		 */
		
		String str1 = "HTA";
		
		String str2 = str1.substring(1);	// TA
		String str3 = str1.substring(0, 2);
		
		System.out.println(str2);
		System.out.println(str3);
		
		String str4 = "970212-1234567";
		
		String str5 = str4.substring(0,2);
		System.out.println("태어난 해 : " + str5);
		String str6 = str4.substring(2, 6);
		System.out.println("생일 : " + str6);
		String str7 = str4.substring(7, 8);
		System.out.println("성별 :" + str7);
		
		
	}
}
