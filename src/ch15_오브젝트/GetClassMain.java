package ch15_오브젝트;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GetClassMain {
	
	public static void main(String[] args) {
		KoreaStudent koreaStudent = new KoreaStudent("20230001", "ㄱㅊㅇ");
//		System.out.println(koreaStudent.getClass().getDeclaredMethods());
		
		Method[] methods = koreaStudent.getClass().getDeclaredMethods();
		for(int i = 0; i < methods.length; i++) {
			System.out.println(methods[i].getName());
			System.out.println(methods[i].getReturnType());
		}
		
		System.out.println();
		
		Field[] fields = koreaStudent.getClass().getDeclaredFields();
		for(int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getName());
		}
		
		System.out.println();
		System.out.println(KoreaStudent.class == koreaStudent.getClass()); // 자기 자신과의 비교만 가능
//		System.out.println(Object.class == koreaStudent.getClass());
		System.out.println(koreaStudent instanceof Object);
		
		System.out.println(koreaStudent.getClass().getSimpleName());
		System.out.println(koreaStudent.getClass().getName());
		
		
		
		
		
		
		
	}
}
