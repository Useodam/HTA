package thread3;

import java.util.IllegalFormatCodePointException;

public class ATMRunnable implements Runnable{

	private int deposit = 1000000;
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		
		System.out.println("[" + name + "] 출금 전 잔액조회 :" + deposit);
		deposit -= 50000;
		System.out.println("[" + name + "] 출금 후 잔액조회 :" + deposit);
		
		System.out.println();
		
	}
}
