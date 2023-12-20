package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListApp2 {

	public static void main(String[] args) {
		
		// new 키워드를 이용해서 List 인터페이스 구현체인 ArrayList 객체 생성하기
		ArrayList<String> list = new ArrayList<String>();
		
		List<String> list2 = new ArrayList<String>();
		list2.add("고길동");
		list2.add("장발장");
		list2.add("모택동");
		
		
		// Arrays 클래스 메소드 asList(T... t)를 이용해서 List 인터페이스의 구현객체 생성하기
		//(T... t) = 가변길이 매개변수
		List<String> list3 = Arrays.asList("고길동","길동","신길동");
		
		
		// List 인터페이스의 클래스 메소드 of(E e)를 이용해서 List 인터페이스의 구현객체 생성하기
		// 아래의 방법의 생성한 List는 불변객체
		// 새로운 객체를 추가하거나, 기존 객체를 삭제할 수 없다
		List<String> list4 = List.of("홍길동","산길동","산신령");
		
		
	}
}
