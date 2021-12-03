package model;

import java.util.ArrayList;

public class Order {
	private int discount;
	private double totalPrice;
	private String date;

	private Customer aCustomer;
	private ArrayList<OrderLine> orderLines;

	/**
	 * Order constructor
	 */
	public Order (Customer customer) {
		totalPrice = 0;
		aCustomer = customer;

		orderLines = new ArrayList<>();
	}

	/**
	 * Add an order line to the order
	 * @param newOrderLine The order line to be added
	 * @return True if the order line was successfully added
	 */
	public boolean addOrderLine(OrderLine newOrderLine) {
		boolean retVal = false;

		if (orderLines.add(newOrderLine)) {
			retVal = true;
		}

		return retVal;
	}

	/**
	 * Finish the order by calculating the final price 
	 * and applying the discount
	 * @return Final price
	 */
	public double finishOrder() {
		for (OrderLine aLine : orderLines) {
			totalPrice += aLine.getSubTotal();
		}
		totalPrice = totalPrice * (1 - (discount / 100));
		return totalPrice;
	}

	/**
	 * Get receipt
	 * @return String of the receipt
	 */
	public String getReceipt() {
		StringBuilder returnString = new StringBuilder();
		//TODO print date
		returnString.append("Customer\n");
		returnString.append(aCustomer.getName());
		returnString.append(aCustomer.getPhoneNumber());
		returnString.append("\n\n");

		returnString.append(getOrderLineItems());
		returnString.append("\n");

		returnString.append("Total:\t" + totalPrice);
		returnString.append("\n");
		

		return returnString.toString();
	}

	/**
	 * Get info about all items in the order
	 * @return String of the items
	 */
	public String getOrderLineItems() {
		StringBuilder returnString = new StringBuilder();

		for (OrderLine aLine : orderLines) {
			returnString.append(aLine.getInfo());
			returnString.append("\n");
		}

		return returnString.toString();
	}


	/**
	 * Get totalPrice.
	 *
	 * @return totalPrice as double.
	 */
	public double getTotalPrice() {
	    return totalPrice;
	}
}
