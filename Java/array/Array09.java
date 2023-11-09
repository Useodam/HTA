package array;

import java.util.Arrays;

public class Array09 {
	public static void main(String[] args) {
		
		String[] names = {"김","이","박"};
		
		System.out.println("일반 for문으로 배열의 모든 값을 처리하기");
		for (int i=0; i<names.length; i++) {
			System.out.print(names[i] + "  ");
		}
		
		System.out.println();
		
		System.out.println("향상된 for문으로 배열의 모든 값을 처리하기");
		for (String i : names) {
			System.out.print(i + "  ");
		}
		
		System.out.println();
		
		// streamAPI 
		// stream : 하나씩 순서대로 흘려보내다
		// foreach : 하나씩 처리하다
		System.out.println("for ~ each문으로 배열의 모든 값을 처리하기");
		Arrays.stream(names).forEach(value -> System.out.print(value + "  "));
	}
}
