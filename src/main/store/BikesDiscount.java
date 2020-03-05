package store;

public class BikesDiscount implements DiscountCalculator{

	public float calculateDiscount(OrderItem orderItem) {
		float itemAmount = orderItem.getProduct().getUnitPrice() * orderItem.getQuantity();
		return itemAmount * 20 / 100;
	}
}
