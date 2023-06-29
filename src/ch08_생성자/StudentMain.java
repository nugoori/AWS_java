package ch08_생성자;

public class StudentMain {

	public static void main(String[] args) {
		Student s1 = new Student("rwd"); // 객체 생성 / 생성자 호출 / 주소 생성 / 매개변수를 활용하여 생성과 동시에 s1에 데이터 대입 가능
		System.out.println(s1);
//		s1.name = "김준일";
//		s1.age = 30;
//		s1.address = "동래구";
		
		System.out.println(s1.name);

	}

}
