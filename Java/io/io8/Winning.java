package io8;

import java.util.Set;

public class Winning {

	private int rank;				// 당첨순위
	private Set<Integer> numbers;	// 로또번호
	private Set<Integer> correctNumbers;	// 맞힌 로또번호
	private int count;				// 맞은 갯수
	private boolean isWin;			// 당쳠여부
	
	public Winning () {
		
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Set<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(Set<Integer> numbers) {
		this.numbers = numbers;
	}

	public Set<Integer> getCorrectNumbers() {
		return correctNumbers;
	}

	public void setCorrectNumbers(Set<Integer> correctNumbers) {
		this.correctNumbers = correctNumbers;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isWin() {
		return isWin;
	}

	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}

	
	
	
	
}
