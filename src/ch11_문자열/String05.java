package ch11_문자열;

public class String05 {

	public static void main(String[] args) {
		
		String name = " "; // null은 따로 처리
		
		boolean flag = name.isBlank(); // 빈 값을 처리하는데 일반적으로 사용
		System.out.println(flag);
		
		boolean flag2 = name.isEmpty();
		System.out.println(flag2);
		
		
		
		
	}
}
