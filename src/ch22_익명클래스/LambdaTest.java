package ch22_익명클래스;

public class LambdaTest {

	public static void main(String[] args) {
		
		// 람다식이 가능하려면 인터페이스에는 추상 메소드가 하나만 존재해야 한다.( 클래스명도 함수명도 없기 때문)
		
		/*		이 부분이 중요		*/ // getAuthority를 정의한 객체로 생성도 동시에 가능
		GrantedAuthorities authorities = () -> {
			System.out.println("권한 출력");			
			return "ROLE_USER";
		};
		
		//	3. 매개변수의 타입을 추론할 수 있는 경우에는 타입을 생략할 수 있습니다.
		//		
		//	4. 매개변수 작성부에서  변수가 하나인 경우에는 괄호(())를 생략할 수 있습니다.
		//
		//	5. 함수의 몸체가 하나의 명령문만으로 이루어진 경우에는 중괄호({})를 생략할 수 있습니다. (이때 세미콜론(;)은 붙이지 않음)
		//
		//	6. 함수의 몸체에 return 문이 있는 경우에는 중괄호({})를 생략할 수 없습니다.
		//
		//	7. return 문 대신 표현식을 사용할 수 있으며, 이때 반환값은 표현식의 결괏값이 됩니다. (이때 세미콜론(;)은 붙이지 않음)
		
		authorities.getAuthority();
		
		Integer[] test = {1,2,3,4,5,6,7,8,9,10};
	}
}
