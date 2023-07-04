package ch20_컬렉션;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapMain {

	public static void main(String[] args) {
		
		// key == set
		HashMap<String, String> strMap = new HashMap<>();
		strMap.put("username", "aaa");
		strMap.put("password", "1234");
		strMap.put("name", "ㄱㅈㅇ");
		
//		System.out.println(strMap);
//		System.out.println(strMap.get("username"));
		strMap.entrySet();
		
		// 더 선호되는 방법
		for(Entry<String, String> entry : strMap.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			
		}
		System.out.println("=======");
		for(String key : strMap.keySet()) {
			System.out.println(key);
			System.out.println(strMap.get(key));
		}
	}
}
