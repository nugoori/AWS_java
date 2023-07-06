package 능력단위평가;

class Order {

	private int orderId;
	private String productName;
	private String consumerName;
	private int price;
	private int stock;
	
	public Order() {
		
	}
	
	public Order(int orderId, String productName, String consumerName, int price, int stock) {
		this.orderId = orderId;
		this.productName = productName;
		this.consumerName = consumerName;
		this.price = price;
		this.stock = stock;
	}
	
	public static OrderBuilder builder() {
		return new OrderBuilder();
	}
	
	public static class OrderBuilder {
		private int orderId;
		private String productName;
		private String consumerName;
		private int price;
		private int stock;	
			
		public Order build() {
			return new Order(orderId, productName, consumerName, price, stock);
		}

		public OrderBuilder orderId(int orderId) {
			this.orderId = orderId;
			return this;
		}
		public OrderBuilder productName(String productName) {
			this.productName = productName;
			return this;
		}
		public OrderBuilder consumerName(String consumerName) {
			this.consumerName = consumerName;
			return this;
		}
		public OrderBuilder price(int price) {
			this.price = price;
			return this;
		}
		public OrderBuilder stock(int stock) {
			this.stock = stock;
			return this;
		}
	

	}
		public void showOrderInfo() {		
			System.out.println(orderId);
			System.out.println(productName);
			System.out.println(consumerName);
			System.out.println(price);
			System.out.println(stock);
		}
}
