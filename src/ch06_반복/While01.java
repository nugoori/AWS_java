package ch06_반복;

import java.util.Scanner;

public class While01 {

	public static void main(String[] args) {
		// index, 순서 > for // 조건에 의한 반복 > while
		Scanner scanner = new Scanner(System.in);
		int selectNumber = 0;
		boolean flag = true; // break는 한 while문만 종료 시킬 수 있으므로 flag로 전체를 종료시켜야 하는 경우 flag를 주로 사용한다
		
		while(flag) {
			System.out.println("[메뉴]");
			System.out.println("1. 1번");
			System.out.println("2. 2번");
			System.out.println("3. 3번");
			System.out.println("4. 4번");
			System.out.println("5. 종료");
			System.out.print("메뉴 번호: ");
			selectNumber = scanner.nextInt();
			
			if(selectNumber == 5) {
				flag = false;				
			} else if(selectNumber == 1) {
				boolean flag2 = true;
				char selectedMenu = 0;
				
				while(flag2) {
					System.out.println("[1번 메뉴 안쪽]");
					System.out.println("a. a메뉴");
					System.out.println("b. b메뉴");
					System.out.println("c. 뒤로가기");
					System.out.println("d. 종료");
					System.out.print("메뉴선택: ");
					selectedMenu = scanner.next().charAt(0);
					
					if(selectedMenu == 'c') {
						flag2 = false;
					}
				}
				System.out.println("메뉴로 돌아갑니다");
			}
		}
		System.out.println("프로그램 종료");
		
		
		
		
	}

}
