package ch15_오브젝트;

public class EqualsMain {

	public static void main(String[] args) {
		
		KoreaStudent koreaStudent1 = new KoreaStudent("20230001", "ㅂㅈㅁ");
		KoreaStudent koreaStudent2 = new KoreaStudent("20230002", "ㅈㄱㅇ");
		KoreaStudent koreaStudent3 = new KoreaStudent("20230003", "ㄱㅎㅎ");
		KoreaStudent koreaStudent4 = new KoreaStudent("20230001", "ㅂㅈㅁ");
		
		// 주소 비교
		System.out.println(koreaStudent1 == koreaStudent4);
		
		// 값 비교
		System.out.println(koreaStudent1.getStudentCode() == koreaStudent4.getStudentCode() 
				&& koreaStudent1.getName() == koreaStudent4.getName());
		// equals로 한줄로 줄일 수 있다.
		System.out.println(koreaStudent1.equals(koreaStudent2));
		
		
	}
}
