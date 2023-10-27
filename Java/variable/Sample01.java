package variable;

public class Sample01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 변수 생성
		/*
		 * 자료형 변수명;
		 * 예)
		 * 		int 	num;
		 * 		long 	num2;
		 * 		boolean ispassed;
		 * 		char 	ch1;
		 * 		char 	ch2;
		 * 
		 * 	변수를 정의하면 메모리에 지정된 자료형에 맞는 공간이 할당되고,
		 * 	할당된 공간(저장소)은 변수명으로 엑세스할 수 있다.
		 */
		
		// 변수 생성하기
		int a;	// 메모리에 정수를 저장할 수 있는 공간이 확보되고, 그 저장소를
				// a라는 변수명으로 엑세스할 수 있게 되었다.
		
//		초기화하지 않는 변수는 출력이나 연산에 사용할 수 없다
//		System.out.println(a);
		
		// 변수 초기화
		a = 100;	// 변수 a에 값을 대입한다
					// 변수에 값을 대입/저장하는 것을 "변수를 초기화한다"라고 한다
					// 초기화된 변수(저장소에 값이 저장되었음)는 연산 및 출력에 사용가능하다.
		
		System.out.println("a의 값 "+a);
	}

}
