package collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorApp {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("홍","고","길","동","황");
		
		System.out.println("일반 for문을 사용해서 반복처리하기 - List 계열만 가능");
		int size = list.size();
		
		for(int index = 0; index<size; index++) {
			String name = list.get(index);
			System.out.println(name);
		}
		
		System.out.println("향상된 for문을 사용해서 반복처리하기");
		for (String name : list) {
			System.out.println("이름: "+name);
		}
		
		System.out.println("Iterator를 사용해서 반복처리하기");
		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {	// hasNext()로 반복할 요소가 남았는지 확인하기
			String name = itr.next();	// next로 요소 꺼내기
			System.out.println(name);
			
		}
		
		System.out.println("Stream을 사용해서 반복처리하기");
		list.stream().forEach(name -> System.out.println(name));
	}
}
