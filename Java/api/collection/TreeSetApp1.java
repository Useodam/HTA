package collection;

import java.util.TreeSet;

public class TreeSetApp1 {

	public static void main(String[] args) {
		
		/*
		 * TreeSet<E>
		 * 	- Set<E>의 구현 클래스다
		 * 	- 중복된 객체의 저장을 허용하지 않는다
		 * 	- 객체가 저장될 때 오름차순으로 정렬되어 저장된다
		 * 	  단, TreeSet에 저장하는 객체는 반드시 Comparable<E>를 인터페이스를 구현한 객체여야 한다
		 * 	  String, Wrapper 클래스는 Comparable<E>를 인터페이스 구현하고 있다
		 */
		TreeSet<String> set = new TreeSet<String>();
		set.add("고길동");
		set.add("너길동");
		set.add("노길동");
		set.add("하길동");
		set.add("정길동");
		set.add("박길동");
		
		for(String s : set) {
			System.out.println(s);
		}
	}
}
