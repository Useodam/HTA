package thread4;

public class Consumer extends Thread{

	private Repo repo;
	
	public Consumer (Repo repo) {
		this.repo = repo;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < 10; i++) {
				repo.consume();
				Thread.sleep(300);
			}
		} catch (Exception ex) {
			
		}
	}
}
