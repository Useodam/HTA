package lang;

import java.util.Arrays;

public class StudentApp {

	public static void main(String[] args) {
		
		Student[] arr = {
				new Student(10, "고길동"),
				new Student(1, "홍길동"),
				new Student(4, "이길동"),
				new Student(11, "정길동"),
				new Student(18, "박길동"),
				new Student(24, "최길동"),
				new Student(37, "김길동"),
		};
	
		Arrays.sort(arr);
	
		for(Student s : arr) {
			System.out.println(s.no + "  " + s.name);
		}
	
	
	}
}
