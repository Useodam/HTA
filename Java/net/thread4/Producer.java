package thread4;

public class Producer extends Thread {

	private Repo repo;
	public Producer(Repo repo) {
		this.repo = repo;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < 10; i++) {
				repo.produce(i);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
