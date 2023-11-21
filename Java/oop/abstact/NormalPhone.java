package abstraction;

public class NormalPhone implements Phone{

	@Override
	public void call(String number) {
		System.out.println("["+number+"]번호로 전화를 겁니다");
		
	}

	@Override
	public void receive() {
		System.out.println("전화를 받습니다");
		
	}

	@Override
	public void sms(String to, String message) {
		System.out.println("["+to+"]로 ["+message+"]를 보냅니다");
		
	}

	
}
