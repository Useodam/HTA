package array;

import java.util.Arrays;
import java.util.Scanner;

public class Array07 {
	public static void main(String[] args) {
		
		/*
		 * 임의의 숫자 10개가 저장되어 있는 배열을 생성하고,
		 * 복사시작위치, 복사종료위치를 입력받아서 원본배열에서 
		 * 해당 범위의 값을 가져와서 새로운 배열을 생성하기
		 */
		
		// 정수타입의 값을 10개 저장할 수 있는 배열 생성
		int[] numbers = new int[10];
		
		for (int i=0; i<numbers.length; i++) {
			// 1 ~ 100사이의 임의의 정수를 배열 numbers[index]에 대입한다
			numbers[i] = (int)(Math.random()*100)+1;
			
		}
		
		System.out.println(Arrays.toString(numbers));
		
		// 시작위치, 종료위치를 입력받기
		
		// 표준입력장치의 입력내용을 읽어오는 Scanner 객체를 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.println("시작위치 입력 : ");
		int start = sc.nextInt();
		System.out.println("종료위치 입력 : ");
		int end = sc.nextInt();
		
		// 원본 배열에서 시작위치부터 종료위치까지 값을 복사해서 새로운 배열에 저장하기
		int[] subArr = new int[end-start+1];
		
		int position = 0;
		for (int index=start; index<=end; index++) {
			subArr[position] = numbers[index];
			position++;
		}
		
		// 새 배열의 값 출력하기
		for (int value : subArr) {
			System.out.print(value + "  ");
		}
		sc.close();
	}
}
