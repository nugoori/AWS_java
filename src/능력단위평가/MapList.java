package 능력단위평가;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapList {

	public static void main(String[] args) {
		
		List<Map<String, Object>> customers = new ArrayList<Map<String, Object>>();	
				
			CustomerMap customerMap = new CustomerMap();
			
			Map<String, Object> customerInfo = customerMap.create();
			Map<String, Object> customerInfo2 = customerMap.create2();
			
			customers.add(0, customerInfo);
			customers.add(1, customerInfo2);
			
					
		for(Map<String, Object> customer : customers) {
			System.out.println("name=" + customer.get("name"));
			System.out.println("rating=" + customer.get("rating"));
			System.out.println("age=" + customer.get("age"));
		}
	}
}
