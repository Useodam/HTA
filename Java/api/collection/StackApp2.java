package collection;

import java.util.Stack;

public class StackApp2 {

	public static void main(String[] args) {
		String[] arr = {"()()","(())()",")()(","(()("};
		
		for(String text : arr) {
			boolean result = check(text);
			System.out.println(result);
		}
	}
	public static boolean check(String text) {
		// 텍스트의 첫번째 문자가 '('이면 false를 반환한다 
		if(text.charAt(0) == ')') {
			return false;
		}
		
		// 텍스트의 마지막번째 문자가 '('이면 false를 반환한다
		int len = text.length();
		if(text.charAt(len-1) == '(') {
			return false;
		}
		
		Stack<Character> stack = new Stack<>();
		
		for(int index=0; index<len; index++) {
			// 문자열에서 지정된 인덱스에 해당하는 문자를 조회한다
			char ch = text.charAt(index);
			
			if(ch =='(') {
				stack.push(ch);
			} else if (ch == ')') {
				stack.pop();
			}
			
			System.out.println(stack);
	}
		
		if(stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	

	}
}
