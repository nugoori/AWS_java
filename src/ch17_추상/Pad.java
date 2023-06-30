package ch17_추상;

import lombok.Data;
import lombok.ToString;

@ToString(callSuper = true)
public class Pad extends SmartDevice {

	private boolean avilability;

	public Pad(String deviceName, double displaySize, boolean avilability) {
		super(deviceName, displaySize);
		this.avilability = avilability;
	}
	
	@Override
	public void connectedWiFi() {
		System.out.println("패드의 와이파이에 연결합니다.");
	}
	
}
