package ch21_JSON;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Json01 {

	public static void main(String[] args) {
		Gson gson = new Gson();
		
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("productCode", "P20230704");
		dataMap.put("productName", "아이폰15");
		System.out.println(dataMap);
			
		// json은 전부 문자열.  네트워크 TCP통신을 할 때는 문자로만 사용 해야하기 때문에 json을 주로 사용
		// 문자열 형태의 데이터를 수신하여 객체로 변환 해서 사용하고 다시 문자열 형태로 변환해서 송신한다.
		JsonObject jsonObject = new JsonObject(); 
		jsonObject.addProperty("productCode", "P20230704");
		jsonObject.addProperty("productName", "아이폰15");
		System.out.println(jsonObject);
		
		System.out.println(gson.toJson(dataMap));
		Map<String, Object> jsonMap = gson.fromJson(jsonObject, Map.class);
		System.out.println(jsonMap.get("productName"));
	
		
	}
}
