package collection;

import java.util.Random;
import java.util.TreeSet;

public class TreeSetApp2 {

	public static void main(String[] args) {
		
		/*
		 * 로또번호 추출하기
		 * 	- TreeSet<E> 사용
		 * 	  1. 중복된 값을 저장하지 않는다
		 * 	  2. 값이 오름차순으로 정렬되어 저장된다
		 * 
		 */
		
		Random random = new Random();
		
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		
		while (true) {
			int num = random.nextInt(45)+1;
			System.out.println(num);
			lotto.add(num);
			
			if(lotto.size() == 6) {
				break;
			}
		}
		
		System.out.println(lotto);
	}
}
  