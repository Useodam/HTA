package io8;

import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

/*
 * 로또 추첨번호를 표현하는 클래스다.
 */

public class Lotto {

	private int no;					// 회차번호
	private Set<Integer> numbers;	// 추첨번호
	private int bonus;				// 보너스 번호

	
	public Lotto()	{}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public Set<Integer> getNumbers() {
		return numbers;
	}


	public void setNumbers(Set<Integer> numbers) {
		this.numbers = numbers;
	}


	public int getBonus() {
		return bonus;
	}


	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	/**
	 * 로또 당첨번호를 문자열로 반환한다
	 * "회차번호:번호1,번호2,번호3,번호4,번호5,번호6:보너스번호:의 형식으로
	 * 로또 당첨번호 정보를 변환한다
	 * @return
	 */
	public String toText() {
		// 문자열로 변경할 로또 당첨번호 정보를 저장하는 임시저장소를 가진 StringBuilder 객체를 생성한다
		StringBuilder sb = new StringBuilder();
		// 회차번호를 담는다
		sb.append(no);
		sb.append(":");
		// 로또 당첨번호를 "," 구분문자로 이어붙이는 StringJoiner 객체를 생성하고,
		// 모든 당첨번호를 StringJoiner에 추가한다
		StringJoiner joiner = new StringJoiner(",");
		for(int number : numbers) {
			joiner.add(String.valueOf(number));
		}
		
		// ","로 이어붙여진 당첨번호를 StringBuilder의 임시저장소에 저장한다
		sb.append(joiner.toString());
		sb.append(":");
		// 보너스번호를 StringBuilder의 임시저장소에 저장한다 
		sb.append(bonus);
		
		return sb.toString();
	}
	
	/**
	 * 지정된 텍스트를 분석해서 Lotto 객체를 반환한다
	 * @param text "회차번호:번호1,번호2,번호3,번호4,번호5,번호:보너스번호"
	 * @return 로또 당첨번호 저장
	 */
	public static Lotto toLotto(String text) {
		String[] items = text.split(":");
		int lottoNo = Integer.parseInt(items[0]);
		Set<Integer> numbers = toSet(items[1]);
		int bonus = Integer.parseInt(items[2]);
		
		Lotto lotto = new Lotto();
		lotto.setNo(lottoNo);
		lotto.setNumbers(numbers);
		lotto.setBonus(bonus);
		
		return lotto;
	}
	
	/**
	 * 지정된 텍스트를 분석해서 로또번호를 Set 객체에 담아서 반환한다
	 * @param text 번호1, 번호2, 번호3, 번호4, 번호5, 번호6
	 * @return
	 */
	private static Set<Integer> toSet(String text) {
		String[] items = text.split(",");
		Set<Integer> set = new TreeSet<Integer>();
		for(String s : items) {
			set.add(Integer.parseInt(s));
		}
		
		return set;
	}
}
