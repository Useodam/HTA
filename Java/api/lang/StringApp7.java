package lang;

public class StringApp7 {
	
	
	public static void main(String[] args) {
		
		/*
		 * String[] split(String delim)
		 * 	- 문자열을 지정된 구분문자로 잘라서 잘려진 각 문자열을 배열에 담아 반환한다
		 */
		
		String str = "홍길동,김유신,고길동";
		String[] items = str.split(",");
		
		System.out.println(items[0]);
		System.out.println(items[1]);
		System.out.println(items[2]);
		

		for(String name : items) {
			System.out.println(name);
		}
		

		
	}
}
