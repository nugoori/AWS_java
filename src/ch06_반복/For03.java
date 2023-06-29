package ch06_반복;

import java.util.Scanner;

public class For03 {
	public static void main(String[] args) {
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		// my 증감식에 --쓰는건 별로 않좋음
		for(int i = 5; i > -1; i--) {
			for(int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}		
		
		System.out.println("----------------");
		// 풀이
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5 - (i+1); j++) {
				System.out.print(" ");
			}			
			for(int k = 0; k < i+1; k++) {
				System.out.print("*");
			}
			System.out.println();			
		}		
		
		System.out.println("----------------");
		// 구구단
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		for(int i = 1; i <= 9; i++) {
			System.out.println(n + " * " + i + " = " + n * i);
		}
			
//		System.out.println("----------------");	
//
//		for(int i = 1; i <= 9; i++)
//		{
//			for(int j = 2; j < 5; j++)
//			{
//				System.out.printf("%d * %d = %2d\t", j, i, j * i);
//			}
//			System.out.println();
//		}

		for(int n1 = 0; n1 >= 1; n1++) {
			for(int n2 = 0; n2 <= 10000; n2++) {
				
			}
		}
		
	}
}
