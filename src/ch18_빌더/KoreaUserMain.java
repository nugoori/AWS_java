package ch18_빌더;

public class KoreaUserMain {

	public static void main(String[] args) {
		
		KoreaUser koreaUser = KoreaUser.builder() // 100번 주소(new KoreaUserBuilder()객체의 주소) 리턴
				.userId(1) // .100번 주소 참조 후 100번 주소 리턴
				.username("aaa")
				.password("1234")
				.name("ㄱㄷㅇ")
				.email("qwer@qwer.qwer")
				.build();
		
		
		
	}
}
