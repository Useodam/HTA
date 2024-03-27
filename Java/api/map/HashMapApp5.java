package map;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HashMapApp5 {

	public static void main(String[] args) {
		// 회원이름 목록을 집계해서 성씨별 인원수를 구하기
		// Map 객체를 이용해서 key : 성씨 , value : 인원수로 구성하면 된다
		
		
		// 회원이름 목록
		String[] names = {"홍길동","허균","길동","고길동","둘리","호잇","해리케인","김민재","홍박사"};
		
		
		// 성씨별 인원수를 저장할 Map 객체를 생성한다
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(String name : names) {
			// 이름에서 성씨를 조회한다
			String key=name.substring(0,1);
			
			// 해당 성씨가 Map 객체에 key로 포함되어 있는지 여부를 조회한다
			// 조회결과 true면 Map 객체에 해당 성씨로 등록된 인원수 정보가 존재함으로
			//					Map에서 성씨로 현재 인원수를 조회하고,
			//					조회된 인원수에 1을 더해서 다시 저장한다
			//			false면 Map 객체에 해당 성씨로 등록된 정보가 없으므로
			//					Map 객체에 (key:성씨, value:1)을 저장한다
			boolean isContains = map.containsKey(key);
			if(isContains) {
				int count = map.get(key);
				map.put(key, count+1);
			} else {
				map.put(key, 1);
			}
			
		}
		
		
		System.out.println(map);
	}
}
