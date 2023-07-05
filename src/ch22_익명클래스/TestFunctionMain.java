package ch22_익명클래스;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestFunctionMain {

	public static void main(String[] args) {
		
//		TestFunction function1 = () -> {
//			System.out.println("매개변수 x, 리턴 x");
//		};

								/* -> : TestFunction의 추상 메서드를 생성하고 구현 */	
		TestFunction function1 = () -> System.out.println("매개변수 x, 리턴 x");
		
		function1.test();	
		
//		TestFunction2 function2 = (int num) -> {
//			System.out.println("매개변수 1개, 리턴 x");
//			System.out.println("num: " + num);
//		};
		
		TestFunction2 function2 = num -> {
			System.out.println("매개변수 1개, 리턴 x");
			System.out.println("num: " + num);
		};
		
		function2.test(3);
		// override한 거라 매개변수 명 변경이 가능하다
		TestFunction3 function3 = (age, name) -> {
			System.out.println("매개변수 2개, 리턴x");
			System.out.println("나이 :" + age);
			System.out.println("이름 :" + name);
		};
		
		function3.test(30, "ㄱㅈㅇ");
		
//		TestFunction4 function4 = (age, name) -> {
//			System.out.println("매개변수 2개, 리턴 O");
//			return "나이: " + age + ", 이름: " + name;
//		};

		TestFunction4 function4 = (age, name) -> "나이: " + age + ", 이름: " + name;
		
		String result1 = function4.test(29, "ㄱㄷㅇ");
		System.out.println(result1);
		
	System.out.println("=== 기본 함수형 인터페이스 ===");
		
		Runnable runnable = () -> {
			System.out.println("매개변수 x, 리턴 x");
		};
		runnable.run();
		
		Consumer<String> consumerStr = name -> {
			System.out.println(name);
		};
		consumerStr.accept("ㄱㅈㅁ");
		
		BiConsumer<String, Integer> biConsumer = (name, age) -> {
			System.out.println("이름: " + name);
			System.out.println("나이: " + age);
		};
		biConsumer.accept("ㄱㅈㅇ", 30);
		
		Supplier<Integer> supplier = () -> 100;		
		System.out.println(supplier.get());
		
		Function<Integer, String> function = year -> "생일: " + year;
		System.out.println(function.apply(1994));
		
		// Predicate<T , 참/ 거짓에 따라 출력>
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		System.out.println(numbers);
		numbers.removeIf(num -> num % 2 == 0);
		System.out.println(numbers);
		
		// 향상된 for문을 함수형으로 만든 것
		numbers.forEach(num -> System.out.println("출력: " + num));
		
		     /* 새 지역 변수 선언 ( 선언은 한 번만 )  */
		// for(      User user          : users) {
//				user = new User(); 
//				== User user = new User();를 users의 수 만큼 반복
//			}
		
	}
}
