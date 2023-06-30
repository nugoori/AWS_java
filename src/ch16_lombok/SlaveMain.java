package ch16_lombok;

public class SlaveMain {

	public static void main(String[] args) {
		
		Slave slave = new Slave("ㅂㅈㅇ", 25);
		Slave slave2 = new Slave("ㅂㅈㅇ", 25);
//		new Slave();
		
		System.out.println(slave.toString());
		System.out.println(slave.getName());
		System.out.println(slave.getAge());
		System.out.println(slave.equals(slave2));
		
		
		
	}
}
