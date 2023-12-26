package enum1;

public class App3 {

	public static void main(String[] args) {
		
		Grade grade1 = Grade.GOLD;

//		Grade grade3 = Grade.BRONZE;
		
		System.out.println("열거객체의 상수명 : " + grade1.name());
		System.out.println("열거객체의 고유한 값1[등급명] : " + grade1.getName());
		System.out.println("열거객체의 고유한 값2[적립률] : " + grade1.getdepositRate());
		
		Grade grade2 = Grade.valueOf("SILVER");
		System.out.println("열거객체의 상수명 : " + grade2.name());
		System.out.println("열거객체의 고유한 값1[등급명] : " + grade2.getName());
		System.out.println("열거객체의 고유한 값2[적립률] : " + grade2.getdepositRate());
	}
}
