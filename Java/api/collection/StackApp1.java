package collection;

import java.util.Stack;

public class StackApp1 {

	public static void main(String[] args) {
		
		/*
		 * Stack<E> 클래스
		 * 	- last-in-first-out (LIFO) 자료구조 구현 클래스
		 * 		후입선출 : 가장 나중에 추가한 값이 제일 먼저 인출된다.
		 * 	- 주요 메소드
		 * 		E push(E item)
		 * 			지정된 객체를 스택의 맨 위에 추가한다
		 * 		E pop()
		 * 			스택의 맨 위에 있는 객체를 삭제하고, 그 객체를 반환한다 
		 * 		E peek()
		 * 			스택의 맨 위에 있는 객체를 삭제없이 반환한다.
		 * 
		 * 	- Stack은 List 인터페이스의 구현 클래스다.
		 * 	  Stack 구현클래스의 고유한 기능을 사용하기 위해서는 Stack 타입의 참조변수에
		 * 	  객체를 대입해야 한다
		 */
		
		Stack<String> stack = new Stack<String>();
		
		stack.push("홍길동");
		stack.push("고길동");
		stack.push("길동");
		
		System.out.println(stack);
		
		String name1 = stack.pop();
		System.out.println("인출한 객체: "+name1);
		System.out.println(stack);
		
		String name2 =stack.pop();
		System.out.println("인출한 객체: "+name2);
		System.out.println(stack);
	}
}
