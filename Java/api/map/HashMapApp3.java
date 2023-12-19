package map;

import java.util.HashMap;
import java.util.Map;

public class HashMapApp3 {

	public static void main(String[] args) {
		
		/*
		 * Map을 사용해서 if문을 제거하기
		 */
		
		// Map을 사용하기 전
		double goldDepositRate = 0.05;
		double silverDepositRate = 0.02;
		double bronzeDepositRate = 0.01;
		
		String grade = "gold";
		int orderPrice = 1000000;
		int point = 0;
		
		if("gold".equals(grade)) {
			point = (int)(orderPrice*goldDepositRate);
		} else if("silver".equals(grade)) {
			point = (int)(orderPrice*silverDepositRate);
		} else if("bronze".equals(grade)) {
			point = (int)(orderPrice*bronzeDepositRate);
		}
		
		System.out.println("적립포인트 : "+point);
		
		
		// Map을 사용한 후
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("gold", 0.05);
		map.put("silver", 0.02);
		map.put("bronze", 0.01);
		
		// grade는 "gold", "silver", "bronze" 중 하나다.
		double depositRate = map.get(grade);
		point = (int) (orderPrice*depositRate);
		System.out.println("적립포인트 : "+point);
	}
}
