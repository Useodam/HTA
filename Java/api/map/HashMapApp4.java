package map;

import java.util.HashMap;
import java.util.Map;

public class HashMapApp4 {
	
	public static void main(String[] args) {
		
		Map<String, MessageSender> map = new HashMap<String, HashMapApp4.MessageSender>();
		
		map.put("sms", new SmsMessageSender());
		map.put("Email", new EmailMessageSender());
		map.put("kakao", new KakaotalkMessageSender());
		
		User user1 = new User();
		user1.name = "홍길동";
		user1.senderTypes = new String[] {"sms", "Email","kakao"};
		System.out.println("###" + user1.name + "에게 이벤트 메시지 전송하기");
		
		for(String type : user1.senderTypes) {	// type에는 "sms", "kakao"가 전달한다
			MessageSender ms = map.get(type);
			ms.send();
		}
	}
	
	static class User{
		String name;			// 고객명
		String[] senderTypes;	// 고객이 수신동안 메시지 수신방법들
	}
	
	static interface MessageSender{
		void send();
	}
	
	static class SmsMessageSender implements MessageSender{
		public void send() {
			System.out.println("SMS로 메시지를 보낸다.");
		}
	}
	
	static class EmailMessageSender implements MessageSender{
		public void send() {
			System.out.println("Email로 메시지를 보낸다");
		}
	}
	
	static class KakaotalkMessageSender implements MessageSender{
		public void send() {
			System.out.println("카카오톡으로 메시지를 보낸다");
		}
	}
	
}
