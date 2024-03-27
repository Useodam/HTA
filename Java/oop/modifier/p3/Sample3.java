package modifier.p3;

public class Sample3 {

	/*
	 * private 접근제한이 적용된 iv
	 * 	- 같은 클래스내부에서만 접근이 가능
	 * 	- 다른 클래스에서는 접근이 허용되지 않는다
	 */
	private int value1;
	
	/*
	 * 디폴트 접근제한이 적용된 iv
	 * 	- 같은 패키지내의 다른 클래스에 접근이 가능하다
	 */
	int value2;
	
	/*
	 * protected 접근제한이 적용된 iv
	 * 	- 같은 패키지내의 다른 클래스에서도 접근이 가능하다
	 * 	- 다른 패키지에 위치하는 클래스에서는 접근이 허용되지 않는다
	 * 	  단, 이 클래스를 상속받은 하위 클래스는 다른 패키지여도 접근이 가능하다
	 */
	protected int value3;
	
	/*
	 * public 접근제한이 적용된 iv
	 */
	public int value4;
	
}
