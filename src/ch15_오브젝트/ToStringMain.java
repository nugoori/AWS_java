package ch15_오브젝트;

public class ToStringMain {

	public static void main(String[] args) {
		
		KoreaStudent koreaStudent = new KoreaStudent("20230001", "ㄱㅇㅎ");
		
		System.out.println(koreaStudent.toString());
		String str = koreaStudent.toString(); // String 타입의 변수에 대입 가능
//		String str2 = koreaStudent;
	}
}
