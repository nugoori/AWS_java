package ch11_문자열;

public class String01 {

	public static void main(String[] args) {
		String str = new String("코리아 아이티 아카데미");
		System.out.println(str == "코리아 아이티 아카데미"); // 리터럴 값은 본연의 주소를 가짐

		String str2 = new String("코리아 아이티 아카데미"); //문자열 인코딩을 할 수 있음
	
	}
}
