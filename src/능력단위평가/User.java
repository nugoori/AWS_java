package 능력단위평가;

class Car {

	private String company;
	private String model;
	private String color;

	public Car(String company, String model, String color) {
		this.company = company;
		this.model = model;
		this.color = color;
		

	}
	
	@Override
	public String toString() {
		return "[ 자동차 정보 ]"
					+ "\n제조사: " + company
					+ "\n모델명: " + model
					+ "\n색상: " + color;
	}

}

public class UserMain {

    public static void main(String[] args) {

        Car car = new Car("현대자동차", "그랜저", "화이트");

        System.out.println(car);

    
    }

}
