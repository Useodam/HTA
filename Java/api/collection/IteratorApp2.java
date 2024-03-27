package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorApp2 {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("가");
		list.add("나");
		list.add("다");
		list.add("라");
		list.add("마");
		list.add(null);
		list.add("바");
		list.add("바");

		// 컬렉션의 remove(Object o)로
		// 리스트객체에서 처음으로 발견되는 객체만 삭제한다
		list.remove("바");
		System.out.println(list);
		
		// 향상된 for문으로 반복처리 중에 요소 삭제하기
		// 향상된 for문으로 반복처리하는 도중에 컬렉션에 저장된 객체를 삭제할 수 없다
		for(String name : list) {
			if("바".equals(name)) {
	//			list.remove(name); //예외발생 ConcurrentModificationException
			}
		}
		
		// Iterator로 반복처리 중에 요소 삭제하기
		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
			String name = itr.next();
			if ("바".equals(name)) {
				itr.remove();
			}
			System.out.println();
		}
		
		// 컬렉션에 대한 삭제를 하는 작업이면 Iterator를 사용 , 삭제하지 않으면 향상된 for문을 사용하는게 편리하다
	}
}
