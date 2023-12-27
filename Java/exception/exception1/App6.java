package exception1;

public class App6 {

	public static void main(String[] args) {
		
		/*
		 * NumberFormatException
		 * 	- 숫자가 아닌 문자를 포함하고 있는 텍스트를 숫자로 변환할 때 발생되는 예외다
		 * 	- NumberFormatException은 UncheckedException이다.
		 */
		
//		// 페이지 번호
//		String str ="1sdfasdfsd";
//		int pageNo = 1;
//		try {
//			pageNo = Integer.parseInt(str);
//		} catch (NumberFormatException ex) {
//
//		}
//		System.out.println("요청한 페이지 번호 : "+pageNo);
//		
//		int start = (pageNo -1)*10 +1;
//		int end = pageNo*10;
//		
//		System.out.println("조회시작번호 : "+ start);
//		System.out.println("조회종료번호 : "+ end);
		
		// 페이지 번호
		String str = "2 ";
		int pageNo = NumberUtils.toInt(str, 1);
		int start = (pageNo -1)*10 +1;
		int end = pageNo * 10;
		
		System.out.println("페이지 번호 : "+ pageNo);
		System.out.println("조회시작번호 : " + start);
		System.out.println("조회종료번호 : " + end);
	}
}
