package io8;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

public class Order {

	private int lottoNo;				// 회차번호
	private long orderNo;				// 주문번호
	private List<Set<Integer>> numbers;	// 구매한 로또번호
	
	public Order() {}

	public int getLottoNo() {
		return lottoNo;
	}

	public void setLottoNo(int lottoNo) {
		this.lottoNo = lottoNo;
	}

	public long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
	}

	public List<Set<Integer>> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Set<Integer>> numbers) {
		this.numbers = numbers;
	}
	
	// 20231124:123156465432:1,15,24,32,37,38,44//3,5,7,15,18,19
	public static Order toOrder(String text) {
		String[] items = text.split(":");
		
		int lottoNo = Integer.parseInt(items[0]);
		long orderNo = Long.parseLong(items[1]);
		List<Set<Integer>> numbers = toList(items[2]);
		
		Order order = new Order();
		order.setLottoNo(lottoNo);
		order.setOrderNo(orderNo);
		order.setNumbers(numbers);
		
		return order;

	}
	
	
	// text는 1,15,24,32,37,38/3,5,7,15,18,19
	private static List<Set<Integer>> toList(String text) {
		List<Set<Integer>> numbers = new ArrayList<Set<Integer>>();
		
		String[] items = text.split("/");
		for(String s : items) {
			numbers.add(toSet(s));
		}
		
		return numbers;
	}
	
	// text는 1,15,24,32,37,38
	// text는 3,5,7,15,18,19
	private static Set<Integer> toSet(String text) {
		Set<Integer> set = new TreeSet<Integer>();
		String[] items = text.split(",");
		for(String s : items) {
			set.add(Integer.parseInt(s));
		}
		
		return set;
	}
	
	
	
	public String toText() {
		StringBuilder sb = new StringBuilder();
		sb.append(lottoNo);
		sb.append(":");
		sb.append(orderNo);
		sb.append(":");
		
		StringJoiner sj = new StringJoiner("/");
		for(Set<Integer> s : numbers) {
			StringJoiner inJoin = new StringJoiner(",");
			for(Integer num : s) {
				inJoin.add(String.valueOf(num));
			}
			
			sj.add(inJoin.toString());
		}
		sb.append(sj.toString());
		
		return sb.toString();
	}
	
	
	
	
}
