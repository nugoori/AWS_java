package ch10_배열;

public class DoubleArray {

	public static void main(String[] args) {
		String[][] studuents = new String[2][2];
		
		studuents[0][0] = "ㄱㅈㅇ";
		studuents[0][1] = "ㄱㅎㅇ";
		studuents[1][0] = "부산";
		studuents[1][1] = "서울";
		
		for(int i = 0; i < studuents.length; i++) {
			for(int j = 0; j < studuents[i].length; j++) {
				System.out.println(studuents[i][j]);
			}
		}
		
		
		
		
	}
}
