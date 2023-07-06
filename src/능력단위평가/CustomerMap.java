package 능력단위평가;

import java.util.HashMap;
import java.util.Map;

public class CustomerMap {

	public Map<String, Object> create() {
		Map<String, Object> customersInfo = new HashMap<>();			
		customersInfo.put("name", "홍길동");
		customersInfo.put("rating", "vip");
		customersInfo.put("age", "30");
		return customersInfo;
		
	}
	
	public Map<String, Object> create2() {
		Map<String, Object> customersInfo = new HashMap<>();			
		customersInfo.put("name", "김기영");
		customersInfo.put("rating", "gold");
		customersInfo.put("age", "35");
		return customersInfo;
		
	}
}
