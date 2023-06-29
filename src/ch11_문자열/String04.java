package ch11_문자열;

public class String04 {

	public static void main(String[] args) {
		String phone = "    010     9988.1916    ";
		
		String replacePhone = phone
				.replaceAll("-", "")
				.replaceAll(" ", "")
				.replaceAll("[.]", "");  // '.'은 문자열이 아님
	
		System.out.println(replacePhone);
		
		String phone2 = phone.trim();
		System.out.println(phone2);
		

	}

}
