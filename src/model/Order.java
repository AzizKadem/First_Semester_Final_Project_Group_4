package model;

import java.util.ArrayList;
import java.util.Iterator;

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
	
	public boolean isEmpty()
	{
		if(orderLines.size() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Check if product is present in the order
	 * @param aProduct Product that is being looked for
	 * @return True if the product is present
	 */
	public boolean checkOrderForProduct(Product aProduct) {
		boolean found = false;
		int index = 0;

		while (index < orderLines.size() && !found) {
			if (aProduct.equals(orderLines.get(index).getAProduct())) {
				found = true;
			}
			else {
				index++;
			}
		}
		return found;
	}

	/**
	 * Get quantity of products in order line
	 * @param aProduct A product to get the quantity of
	 * @return The quantity of products
	 */
	public int getQuantityOfOrderLine(Product aProduct) {
		int retVal = 0;
		for (OrderLine anOrderLine : orderLines) {
			if (anOrderLine.getAProduct().equals(aProduct)) {
				retVal = anOrderLine.getQuantity();
			}
		}
		return retVal;
	}

	/**
	 * Delete order line containing a product
	 * @param aProduct A product that deleted order line contains
	 * @return True if order line was deleted
	 */
	public boolean deleteOrderLine(Product aProduct) {
		boolean deleted = false;

		Iterator<OrderLine> it = orderLines.iterator();

		while (it.hasNext()) {
			OrderLine thisOrderLine = it.next();

			if (thisOrderLine.getAProduct().equals(aProduct)) {
				it.remove();
				deleted = true;
			}
		}
		return deleted;
	}

	/**
	 * Finish the order by calculating the final price 
	 * and applying the discount
	 * @return Final price
	 */
	public double finishOrder() {
		for (OrderLine aLine : orderLines) {
			totalPrice += aLine.getSubTotal();
			aLine.subtractFromStock();
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
		returnString.append("Customer\nName:\t\t");
		returnString.append(aCustomer.getName());
		returnString.append("\nPhone number:\t");
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
