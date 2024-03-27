package thread4;


public class App {

	public static void main(String[] args) {
		Repo repo = new Repo();
		
		Producer producer = new Producer(repo);
		Consumer consumer = new Consumer(repo);
		
		producer.start();
		consumer.start();
	}
}
