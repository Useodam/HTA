package thread2;

public class ATMApp {

	public static void main(String[] args) {
	
		ATM atm = new ATM();
		
		Thread t1 = new Thread(atm,"엄마");
		Thread t2 = new Thread(atm,"아빠");
		Thread t3 = new Thread(atm,"아들");
		Thread t4 = new Thread(atm,"딸");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
