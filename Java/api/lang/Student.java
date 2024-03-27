package lang;

public class Student implements Comparable<Student>{

	int no;
	String name;
	
	public Student(int no, String name) {
		// TODO Auto-generated constructor stub
		this.no = no;
		this.name = name;
	}
		
	
	
	public String toString() {
		return "{no:" +no+", name :"+name+"}";
	}
	
	@Override
	public int compareTo(Student other) {
		
//		return this.no - other.no;							// 번호순으로 정렬
		return this.name.compareToIgnoreCase(other.name);	// 이름순으로 정렬
	}
}


/*
*	양의 정수 - this의 순위가 뒤다
*	음의 정수 - this의 순위가 앞이다
*	0		  - this와 other의 순위가 동일하다
*/
