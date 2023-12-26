package enum1;

public class App4 {

	public static void main(String[] args) {
		
		Grade grade1 = Grade.BRONZE;
		int orderPrice = 1000000;
		
		double depositRate = grade1.getdepositRate();
		int point = (int) (orderPrice * depositRate);
		
		System.out.println("적립포인트 : " + point);
	}
}
