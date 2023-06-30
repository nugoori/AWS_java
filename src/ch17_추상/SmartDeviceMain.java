package ch17_추상;

public class SmartDeviceMain {

	public static void main(String[] args) {
		
		SmartPhone phone = new SmartPhone("아이폰", 6.1, "010-9988-1916");
		Pad pad = new Pad("아이패드3", 10.1, false);
		
//		SmartDevice device = new SmartDevice(null, 0); // 추상화 : 공통사항을 따로 만들어서 클래스에 담음. 오로지 상속을 통해 구체화를 해야 생성 할 수 있다
		
		System.out.println(phone);
		System.out.println(pad);
		
		phone.connectedWiFi();
		pad.connectedWiFi();
		
		
		
	}
}
