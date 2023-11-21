package abstraction;

public class Iphone implements Phone, SmartPhone{

	@Override
	public void internet() {
		System.out.println("아이폰으로 인터넷을 합니다");
		
	}

	@Override
	public void game() {
		System.out.println("아이폰으로 게임을합니다");
		
	}

	@Override
	public void call(String number) {
		System.out.println("아이폰으로 ["+number+"]로 전화를 겁니다");
		
	}

	@Override
	public void receive() {
		System.out.println("아이폰으로 전화를 받습니다");
		
	}

	@Override
	public void sms(String to, String message) {
		System.out.println("아이폰으로 ["+to+"]에게 ["+message+"]를 보냅니다");
		
	}

	
}
