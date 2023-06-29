package ch07_클래스;

public class BMain {
	public static void main(String[] args) {
		
		B b1 = new B();
		
		b1.test1();
		int num1 = b1.test2();		
		System.out.println(num1);
		// 메소드 실행 후 리턴값을 반환
		System.out.println(b1.test2());
		
		// 함수의 호출과 동시에 리턴값을 반환
		if(b1.test3()) {
			System.out.println("if문을 실행.");
		}
		
		b1.test4("sksk", 30);
		
		
	}
}
