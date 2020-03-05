package store;

public class CloathingDiscount implements DiscountCalculator{

	public float calculateDiscount(OrderItem orderItem) {
		if (orderItem.getQuantity() > 2) {
			return orderItem.getProduct().getUnitPrice();
		}
		return 0;
	}
}
