package ch17_추상;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
public abstract class SmartDevice {

	private String deviceName;
	private double displaySize;
	
	public abstract void connectedWiFi();
	
	
	
	
	
}
