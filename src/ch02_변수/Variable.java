package ch02_변수;

public class Variable {

	public static void main(String[] args) {
		boolean flag;	// 선언
		flag = false;	// 초기화(대입)
		System.out.println("FLAG: " + flag);
		
		char lastName = '김';
		System.out.println(lastName);
		
		int number = 100;
		System.out.println("점수: " + number);
		
		double pi = 3.14;
		System.out.println(pi);
		
		String name = "김준일";
		System.out.println(name);
		
		String num1 = "10";
		int num2 = 10;
		System.out.println("String: " + num1);
		System.out.println("int: " + num2);
		System.out.println(num1 + 10);
		
		char num3 = '5';
		System.out.println(num3 + num2);
		System.out.println((double) num3);
		
		// 1. 묵시적 형변(업캐스팅에서 만 가능 문->정->실)
		int num4 = num3;
		System.out.println(num4);
		// 2. 명시적 형변(다운캐스팅 실->정->문 => 넘치는 데이터는 소실?)
		char num5 = (char) num4;
		System.out.println(num5);
		
		double num6 = 3.15;
		System.out.println((int) num6);
	}

}
