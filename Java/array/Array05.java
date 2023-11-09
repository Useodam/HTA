import java.util.Arrays;
import java.util.Scanner;

public class Array05 {
	public static void main(String[] args) {
		// 임의의 정수값을 여러 개 입력받아서 그 중에서 가장 큰 값을 찾기
		// 키보드를 이용해서 정수 10개를 입력받고 그 중에서 가장 큰 값을 출력한다
		
		Scanner sc = new Scanner(System.in);
		
		// 정수를 10개 저장할 배열객체를 저장한다
		int[] arr1 = new int[5];
		
		// 반복문을 이용해서 숫자를 입력받고 배열에 순서대로 저장한다
		for (int index=0; index<5; index++) {
			System.out.println("숫자 입력 : " );
			arr1[index] = sc.nextInt();
		}
		sc.close();
		
		// 배열에 저장된 값 중에서 최대값  찾기
		int max = Integer.MIN_VALUE;
		for(int value : arr1) {
			if(max < value) {
				max = value;
			}
		}
		
		
		
		System.out.println("입력한 숫자 중 가장 큰 값 : "+max);
		System.out.println("입력받은 숫자 : "+Arrays.toString(arr1));
	}
}
