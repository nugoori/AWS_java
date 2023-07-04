package ch22_익명클래스;

public class AuthorityMain {

	public static void main(String[] args) {
		// 상속을 받지 않고 직접 구현?       /*  익명 클래스  */
		GrantedAuthorities authorities = new GrantedAuthorities() {
			// 생성x 
			@Override
			public String getAuthority() {
				System.out.println("권한 출력");
				return "ROLE_USER";
			}
		};
		System.out.println(authorities.getAuthority());
		
		System.out.println("=== 둘 다 같은 것 ===");
		
		A a = new A();
		System.out.println(a.getAuthority());
	}
}

class A implements GrantedAuthorities {
	
	@Override
	public String getAuthority() {
		System.out.println("두번째 권한 출력");
		return "ROLE_ADMIN";
	}
}
