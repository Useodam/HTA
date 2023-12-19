package map;

import java.util.HashMap;
import java.util.Map;

public class HashMapApp1 {

	public static void main(String[] args) {
		
		/*
		 * Map<K, v>
		 * 	- key, value의 쌍으로 객체를 저장할 수 있는 객체다.
		 * 	- 주오메소드
		 * 		V put(K key, V value)
		 * 			Map 객체에 key, value의 쌍으로 객체를 저장시킨다
		 * 		V get(Object key)
		 * 			Map 객체에서 key에 해당하는 value 객체를 조회한다
		 * 			key가 존재하지 않으면, null을 반환한다
		 * 		V remove(Object key)
		 * 			Map 객체에서  key에 해당하는 Entry를 삭제한다.
		 * 		boolean containsKey(Object key)
		 * 			지정된 key가 존재하는지 조회한다
		 * 		Set<Key> keySet()
		 * 			Map의 모든 key를 Set 객체에 담아서 반환한다
		 * 		Set<Entry<K, V>> entrySet()
		 * 			Map에 저장된 모든 Entry 객체를 Set 객체에 담아서 반환한다
		 * 
		 * 	- 주요 구현 클래스
		 * 		HashMap	- 가장 많이 사용되는 Map 인터페이스 구현 클래스
		 * 		HashTable - key와 value로 null값을 허용하지 않는다
		 * 		
		 */
		
		// key : 아이디, vlaue : 고객명의 쌍으로 Entry가 구성되는 HashMap 객체 생성하기 
		Map<String, String> map1 = new HashMap<String, String>();
		
		// Map 객체에 새로운 Entry 저장하기
		map1.put("홍", "홍길동");
		map1.put("길", "길동");
		map1.put("동", "동");
		map1.put("김", "김길동");
		
		// Map 객체에서 지정된 Key에 해당하는 Value 조회하기
		String value1 = map1.get("홍");
		String value2 = map1.get("길");
		String value3 = map1.get("hong");
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);	// null이 출력된다
		
		// Map 객체에서 지정된 key에 해당하는 Entry를 삭제하기
		map1.remove("김");
		
		// 이미 존재하는 key로 다시 값을 저장하면 기존 값을 덮어쓴다.
		map1.put("홍", "홍홍홍");
		
		
		
		System.out.println(map1);
	}
}
