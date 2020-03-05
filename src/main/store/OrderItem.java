package store;

public class OrderItem {
	
	private Product product;
	private int quantity;

	/*
	 * Order Item Constructor
	 */
	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	float getTotalForItem() {
		float totalItem=0;
		float discount =0;
		DiscountCalculator discountCalculator = createDiscountcalculator();
		discount=discountCalculator.calculateDiscount(this);
		totalItem=calculateTotalAmount()-discount;
		return totalItem;
	}

	private float calculateTotalAmount() {
		float itemAmount = getProduct().getUnitPrice() * getQuantity();
		return itemAmount;
	}
	
	DiscountCalculator createDiscountcalculator() {
		DiscountCalculator discountCalculator = null;
		if (getProduct().getCategory() == ProductCategory.Accessories) {
			discountCalculator= new AccesoriesDiscount();
		}
		if (getProduct().getCategory() == ProductCategory.Bikes) {
			discountCalculator= new BikesDiscount();
		}
		if (getProduct().getCategory() == ProductCategory.Cloathing) {
			discountCalculator= new CloathingDiscount();
		}
		return discountCalculator;
	}
}
