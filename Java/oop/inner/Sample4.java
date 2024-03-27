package inner;

public class Sample4 {

	public static void main(String[] args) {
		
		SampleInterface 익명객체1= new SampleInterface() {
			public void handle() {
				System.out.println("첫번째 익명객체 구현코드");
			}
		};
		
		익명객체1.handle();
		
		SampleInterface 익명객체2 = new SampleInterface() {
			
			@Override
			public void handle() {
				// TODO Auto-generated method stub
				System.out.println("두번째 익명객체 구현코드");
				
			}
		};
		
		익명객체2.handle();
	}
}
