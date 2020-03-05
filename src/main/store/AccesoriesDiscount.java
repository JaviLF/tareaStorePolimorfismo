package store;

public class AccesoriesDiscount implements DiscountCalculator{
	
	public float calculateDiscount(OrderItem orderItem) {
		float itemAmount = orderItem.getProduct().getUnitPrice() * orderItem.getQuantity();
		if (itemAmount >= 100) {
			return itemAmount * 10 / 100;
		}
		return 0;
	}
}
