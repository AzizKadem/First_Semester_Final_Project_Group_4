package model;
import java.util.ArrayList;
import java.util.Iterator;


public class Order {
	//TODO add ID/index
	private int discount;
	private double totalPrice;
	private Date date;

	private Customer aCustomer;
	private ArrayList<OrderLine> orderLines;

	/**
	 * Order constructor
	 */
	public Order (Customer customer) {
		totalPrice = 0;
		aCustomer = customer;
		date = new Date();
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
			newOrderLine.subtractFromStock();
			retVal = true;
		}

		return retVal;
	}
	
	/**
	 * Check if the order is empty
	 * @return True if the order is empty
	 */
	public boolean isEmpty() {
		boolean retVal = false;

		if(orderLines.size() == 0) {
			retVal = true;
		}
		return retVal;
	}
	
	/**
	 * Add to stock quantity of products that are in the order line
	 * @param aProduct Product that is in the order line
	 */
	public void addToStock(Product aProduct) {
		OrderLine aLine = findOrderLineByProduct(aProduct);
		
		if (aLine != null) {
			aLine.addToStock();
		}
	}

	/**
	 * Check if product is present in the order
	 * @param aProduct Product that is being looked for
	 * @return True if the product is present
	 */
	public boolean checkOrderForProduct(Product aProduct) {
		boolean found = false;

		if (findOrderLineByProduct(aProduct) != null) {
			found = true;
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
	 * Get receipt
	 * @return String of the receipt
	 */
	public String getReceipt() {
		StringBuilder returnString = new StringBuilder();
		
		returnString.append("Customer\nName:\t\t");
		returnString.append(aCustomer.getName());
		returnString.append("\nPhone number:\t");
		returnString.append(aCustomer.getPhoneNumber());
		returnString.append("\n\n");

		returnString.append(getProductsAndPrice());
		

		returnString.append("\nDate of purchase:\t");
		returnString.append(date.getDateTime());
		returnString.append("\n\n");
		
		return returnString.toString();
	}
	
	/**
	 * Get all products and a price of this order line
	 * @return String of all products and a price
	 */
	public String getProductsAndPrice() {
		StringBuilder returnString = new StringBuilder();
		
		returnString.append(getOrderLineItems());
		returnString.append("\n");

		returnString.append("Total:\t" + getPrice());
		returnString.append("\n");
		
		return returnString.toString();
	}
	

	/**
	 * Get info about all items in the order
	 * @return String of the items
	 */
	public String getOrderLineItems() {
		calculateTotalPrice();
		StringBuilder returnString = new StringBuilder();

		for (OrderLine aLine : orderLines) {
			returnString.append(aLine.getInfo());
			returnString.append("\n");
		}

		return returnString.toString();
	}
	
	/**
	 * Cancel Order and return items
	 * @return Items that were cancelled
	 */
	public String cancelOrder() {
		StringBuilder returnString = new StringBuilder();
		returnString.append("Order Canceled with ");
		returnString.append(orderLines.size());
		returnString.append(" products:\n");
		
		for (OrderLine aLine : orderLines) {
			returnString.append(aLine.getInfo());
			aLine.addToStock();
		}
		
		return returnString.toString();
		
	}


	/**
	 * Get totalPrice.
	 *
	 * @return totalPrice as double.
	 */
	public void calculateTotalPrice() {
		totalPrice = 0;
		for (OrderLine aLine : orderLines) {
			totalPrice += aLine.getSubTotal();
		}
	    totalPrice = totalPrice * (1 - (discount / 100));
	}
	
	public double getPrice() {
		return totalPrice;
	}
	

	/**
	 * Find an order line by a product
	 * @param aProduct A product that the order line contains
	 * @return Found order line (null if not found)
	 */
	private OrderLine findOrderLineByProduct(Product aProduct) {
		int index = 0;
		boolean found = false;
		OrderLine returnLine = null;
		
		while (index < orderLines.size() && !found) {
			if (orderLines.get(index).getAProduct().equals(aProduct)) {
				returnLine = orderLines.get(index);
				found = true;
			}
			else {
				index++;
			}
		}
		
		return returnLine;
	}
}
