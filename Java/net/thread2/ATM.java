package thread2;

public class ATM implements Runnable{
	
	private int balance = 1000000;	// 계좌잔액
	
	public synchronized void run() {
		for (int i=0; i<=10; i++) {
			balance -= 20000;
			
			// 쓰레드의 이름을 가져옴
			String name = Thread.currentThread().getName(); 
			
			System.out.println("[" + name + "] 이 출금함 . 잔액 : [" + balance + "]");
		}
	}
}
