package ch03_연산자;

/*
 * 논리 연산자
 * 1. && - 곱
 * true  && false => false
 * 2. || - 합
 * true || false => true
 * 3. !  - 반전
 * 
 */

public class Operator02 {

	public static void main(String[] args) {
		int year = 1999;
		System.out.println(year % 4 == 0);
		System.out.println(year % 100 != 0);
		System.out.println(year % 400 == 0);
		System.out.println(year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
		System.out.println(year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 1 : 0);
		
		int result = 10 + 1;
		System.out.println(result);
		
		boolean result2 = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		System.out.println(result2);
		
		int result3 = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 1 : 0;
		String result4 = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? "1" : "0"; // 결과에 대한 자료형을 일치시켜야 함
		System.out.println(result3);
		System.out.println(result4);

	}

}
