package store;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {

	private Customer customer;
	private Salesman salesman;
	private Date orderedOn;
	private String deliveryStreet;
	private String deliveryCity;
	private String deliveryCountry;
	private Set<OrderItem> items;

	public Order(Customer customer, Salesman salesman, String deliveryStreet, String deliveryCity, String deliveryCountry, Date orderedOn) {
		this.customer = customer;
		this.salesman = salesman;
		this.deliveryStreet = deliveryStreet;
		this.deliveryCity = deliveryCity;
		this.deliveryCountry = deliveryCountry;
		this.orderedOn = orderedOn;
		this.items = new HashSet<OrderItem>();
	}

	public Customer getCustomer() {
		return customer;
	}

	public Salesman getSalesman() {
		return salesman;
	}

	public Date getOrderedOn() {
		return orderedOn;
	}

	public String getDeliveryStreet() {
		return deliveryStreet;
	}

	public String getDeliveryCity() {
		return deliveryCity;
	}

	public String getDeliveryCountry() {
		return deliveryCountry;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public float total() {
		float totalItems = getTotalForItems();
		float tax = getTax(totalItems);
		int shipping = getShipping();
		return totalItems + tax + shipping;
	}
	
	private int getShipping() {
		if (this.deliveryCountry == "USA"){
			return 0;
		}
		return 15;
	}

	private float getTax(float totalItems) {
		return totalItems * 5 / 100;
	}
	
	private float getTotalForItems() {
		float totalItems = 0;
		for (OrderItem item : items) {
			float totalItem = item.getTotalForItem();
			totalItems += totalItem;
		}
		return totalItems;
	}
}
