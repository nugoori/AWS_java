package 능력단위평가;

public class Main {
	 
	public static void main(String[] args) {
		
		
//		Order order = null;
		Order order = Order.builder()
				.orderId(100)
				.productName("Samsug GalaxyBook2 Pro")
				.consumerName("홍길동")
				.price(1450000)
				.stock(2)
				.build();
			
		order.showOrderInfo();
		
	}
	
	
}


