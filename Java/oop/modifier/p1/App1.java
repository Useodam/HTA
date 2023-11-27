package modifier.p1;

public class App1 {

	public static void main(String[] args) {
		
		/*
		 * App1은 Sample1, Sample2와 같은 패키지에 있는 클래스다
		 * 	- App1은 Sample1, Sample2를 import 구문없이 사용가능하다
		 * 	- App1은 디폴트 접근제한이 적용된 Sample1,
		 * 		public 접근제한이 적용된 Sample2 전부 접근이 가능하다
		 * 
		 */
		Sample1 sample1 = new Sample1();
		Sample2 sample2 = new Sample2();
	}
}
