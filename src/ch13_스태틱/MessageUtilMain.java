package ch13_스태틱;

public class MessageUtilMain {
	
	private int a;
	
	public static void main(String[] args) {
		
		MessageUtil messageUtil = new MessageUtil();
		
//		Array01.main(null);
		
//		messageUtil.sendMail();
//		messageUtil.sendFile();
		
		MessageUtil.sendFile();
		System.out.println();
		MessageUtil.data = "안녕";
		System.out.println(MessageUtil.data);
		
		System.out.println(messageUtil.data);
		
	}
}
