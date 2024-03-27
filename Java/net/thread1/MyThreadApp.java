package thread1;

public class MyThreadApp {

	public static void main(String[] args) {
		
		MyThread t1 = new MyThread("1번 일꾼");
		MyThread t2 = new MyThread("2번 일꾼");
		MyThread t3 = new MyThread("3번 일꾼");
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
