package 능력단위평가;

public class Laptop implements Wifi{

	@Override
	public void connected() {
		System.out.println("노트북을 와이파이에 연결합니다.");
	}
	
	public void onSavingMode() {
		System.out.println("절전 모드를 활성화합니다.");
	}
}
