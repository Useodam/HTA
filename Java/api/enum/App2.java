package enum1;

public class App2 {

	public static void main(String[] args) {
		
		CustomerGrade grade1 = CustomerGrade.GOLD;
		CustomerGrade grade2 = CustomerGrade.SILVER;
		CustomerGrade grade3 = CustomerGrade.BRONZE;
		
		// String name();
		// 열거객체가 표현하는 열거상수의 이름을 반환한다
		String name1 = grade1.name();
		String name2 = grade2.name();
		
		System.out.println("열가상수 이름 : " + name1);
		System.out.println("열가상수 이름 : " + name2);
		
		// int ordinal()
		// 열거객체의 순번을 반환한다
		int index1 = grade1.ordinal();
		int index2 = grade2.ordinal();
		int index3 = grade3.ordinal();
		System.out.println("열거객체 순번 : "+ index1);
		System.out.println("열거객체 순번 : "+ index2);
		System.out.println("열거객체 순번 : "+ index3);
		
		// enum valueOf(String name)
		// 지정된 이름의 열거상수를 표현하는 열거객체를 반환한다
		CustomerGrade grade4 = CustomerGrade.valueOf("GOLD");
		System.out.println(grade4.name());
		

	}
}
