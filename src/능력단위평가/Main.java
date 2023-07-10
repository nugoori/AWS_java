package 능력단위평가;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	 
	public static void main(String[] args) {
		List<Wifi> devices = new ArrayList<>();
			devices.add(new SmartPhone());
			devices.add(new Laptop());
	
		for(Wifi device: devices) {
			if(device.getClass() == SmartPhone.class) {
				device.connected();
				((SmartPhone) device).call();
			}
			if(device.getClass() == Laptop.class) {
				device.connected();
				((Laptop) device).onSavingMode();
			}
			
	
		}
		
		
	}
	
}

