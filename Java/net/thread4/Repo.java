package thread4;

public class Repo {

	private String data;
	
	// 공급자 스레드가 실행하는 메소드
	public synchronized void produce(int no) throws Exception{
		
		if(data != null) {
			wait();
		}
			data = no + "번째값";
			System.out.println("[" + no + "]번째 값을 공급하다");
			notify();	// 소비자의 일시정지를 해제한다
			
		}

	
	// 소비자 스레드가 실행하는 메소드
	public synchronized void consume() throws Exception{

		if (data == null) {
			wait();
		}
		
		System.out.println("["+data+"]를 소비하다.");
		data = null;
		notify();
		System.out.println();
	}
	
	/*
	 * 1. 공급자 스레드가 start() 된 후, 
	 * 		repo.produce() 메소드를 실행한다
	 * 		data가 null이다.
	 * 	  		Repo의 data에 새로운 값을 저장한다
	 *    		notify()를 실행해서 소비자를 실행가능상태로 변경한다
	 *    	repo.produce() 메소드를 실행한다.
	 *    		data가 null이 아니다.
	 *    			wait()를 실행해서 자신(공급자)를 대기상태로 변경한다
	 *    			공급하기......를 실행하지 못하고 대기상태에서 대기중 .... 가 
	 *   
	 * 2. 소비자 스레드가 start() 된 후,
	 * 		repo.consume() 메소드를 실행한다
	 * 			data가 null이다
	 * 				wait()를 실행해서 자신(소비자)를 대기상태로 변경한다	
	 * 				소비하기......를 실행하지 못하고 대기상태에서 대기중..... 나 
	 *    
	 *    
	 */
}
	
	

