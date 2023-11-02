package loop;

public class ForApp02 {
	public static void main(String[] args) {
		
		// 1~100까지 정수의 합을 계산하기
		int sum = 0;
		for (int i=1; i<=100; i++) {
			sum += i;
		}
		System.out.println("1~100 정수의 합 : "+sum);
		
		// 1~100까지 정수 중 짝수의 합을 계산하기
		int sum2 = 0;
		for (int i=2; i<=100; i+=2) {
			sum2 +=i;
		}
		System.out.println("1~100 짝수의 합 : "+sum2);
		
		// 1~100까지 정수 중 홀수의 합을 계산하기
		int sum3 = 0;
		
		for (int i=1; i<=100; i++) {
			if(i%2 == 1) {
				sum3 += i;
			}
		}
		System.out.println("1~100 홀수의 합 : "+sum3);
	}
}
