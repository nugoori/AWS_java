package 능력단위평가;

public class SmartPhone implements Wifi {

	@Override
	public void connected() {
		System.out.println("스마트폰을 와이파이에 연결합니다.");
		
	}
	
	public void call() {
		System.out.println("상대방에게 음성통화를 연결합니다.");
	}


}
