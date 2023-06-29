package ch11_문자열;

public class StringBuilder01 {

	public static void main(String[] args) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("이름: "); // 제일 뒤에 추가
		builder.append("김준일");
		builder.delete(builder.indexOf(":"), builder.indexOf(":") + 1 );
		builder.insert(2, ">>");
		
		String str = builder.toString();
		System.out.println(str);
		
		String name = "이름: 김준일";
		String name2 = name.substring(name.indexOf(""), name.indexOf(":")); 
		String name3 = name.substring(name.indexOf(":") + 1, name.lastIndexOf(""));	
		System.out.println(name2);
		System.out.println(name3);
		System.out.println(name2 + name3);
		
		// 풀이 substring 연습좀 해라
		System.out.println(
				name.substring(0, name.indexOf(":"))
				 .concat(name.substring(name.indexOf(":") + 1))
				 );

		System.out.println(
				name.substring(0, 2)
				 .concat(name.substring(name.indexOf(":") + 1))				
				);
	
	
	
	
	}

}
