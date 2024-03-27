package builder;


public class StringBuilderApp {

	public static void main(String[] args) {
		
		int no = 100;
		String name = "홍길동";
		String tel = "010-1234-5678";
		
		/*
		 * 위의 데이터를 가지고 아래와 같은 영식의 텍스트로 구성하기
		 * 
		 * 		번호:100, 이름:홍길동, 전화번호:010-1234-5678
		 * 
		 * 	- 덧셈 연산자를 이용해서 값을 이어붙이기
		 * 	  + 값의 갯수가 적을 때 사용하자
		 * 	  + 값의 갯수가 많으면 덧셈을 여러 번 실행하게 되고, 덧셈이 실행될 때마다
		 * 		새로운 String 객체가 생성되기 때문에 메모리 누수가 발생할 수 있다
		 * 
		 * 	- StringBuilder 객체 활용하기
		 * 	  + StringBuilder는 객체 내부에 임시저장소를 가지고 있다
		 * 	  + append(값) 메소드를 사용해서 값을 추가하면 임시저장소에 저장될 뿐
		 * 		새로운 객체가 생성되지는 않는다
		 */
		
		// 1. 덧셈 연산자를 이용해서 값을 이어붙이기
		String text = "번호:" + no + ", 이름:" + name + ", 전화번호:" + tel;
		System.out.println(text);
		
		// 2. StringBuilder 객체 활용하기
		StringBuilder sb = new StringBuilder();
		sb.append("번호:");
		sb.append(no);
		sb.append(", 이름:");
		sb.append(name);
		sb.append(", 전화번호:");
		sb.append(tel);
		
		String text2 = sb.toString();
		System.out.println(text2);
	}
}
