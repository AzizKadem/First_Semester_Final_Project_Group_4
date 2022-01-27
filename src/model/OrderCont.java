package model;

import java.util.ArrayList;

public class OrderCont {
	private static OrderCont instance;
	private ArrayList<Order> orders;

	/**
	 * Constructor of the singleton pattern
	 */
	private OrderCont() {
		orders = new ArrayList<>();
	}

	/**
	 * Get instance of the singleton container
	 * @return The instance
	 */
	public static OrderCont getInstance() {
		if (instance == null) {
			instance = new OrderCont();
		}
		return instance;
	}

	/**
	 * Add order to the container
	 * @param newOrder The order to be added
	 * @return True if the order was added successfully
	 */
	public boolean addOrder(Order newOrder) {
		boolean retVal = false;

		if (orders.add(newOrder)) {
			retVal = true;
		}

		return retVal;
	}
	
	/**
	 * Get orders
	 * @return orders
	 */
	public ArrayList<Order> getOrders() {
		return orders;
	}
	/**
	 * Empty the container
	 */
	public void emptyContainer() {
		orders.clear();
	}

	/**
	 * Returns the number of orders made by a customer with the specific phone number
	 * @param phone the phone number of the customer to search for
	 * @return the number of orders
	 */
	public int getNumberOfOrdersByCustomer(String phone) {
		int i = 0;
		for(Order order:orders) {
			if(order.getACustomer().getPhoneNumber().equals(phone)) {
				i++;
			}
		}
		return i;
	}
}
