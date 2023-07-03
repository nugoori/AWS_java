package ch14_싱글톤;

import java.time.LocalDate;
import java.util.Date;

public class Samsung {
	private static Samsung instance; // static instance객체만들고 private 생성자 만들고 getInstance메소드 만들기 == 싱글톤 생성?
	
	private String companyName;
	private int autoIncrementSerialNumber = LocalDate.now().getYear() * 10000;
	
	private Samsung() {
		companyName = Samsung.class.getSimpleName().toUpperCase();
	}
	
	// 싱글톤 : 하나의 유일 객체 생성 패턴? > 보통 기능들을 담을 때 사용
	public static Samsung getInstance() {
		if(instance == null) {
			instance = new Samsung();
		}
		return instance;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public int getAutoIncrementSerialNumber() {
		return autoIncrementSerialNumber;
	}
	
	public void setAutoIncrementSerialNumber(int autoIncrementSerialNumber) {
		this.autoIncrementSerialNumber = autoIncrementSerialNumber;
	}
	
	
}
