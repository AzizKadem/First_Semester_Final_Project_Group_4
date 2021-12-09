package ui;

import Exceptions.EmptyOrder;
import Exceptions.ProductNotFound;
import Exceptions.QuantityUnderrunException;
import controller.OrderCtrl;

import model.OrderLine;
import model.Order;

public class OrderMenu extends Menu {
	private OrderCtrl orderCtrl;
	private TextInput input;

	public OrderMenu() {
		super("Order Menu", "Back");
		super.addOption("Create Order");

		orderCtrl = new OrderCtrl();
		input = new TextInput();
	}

	/**
	 * Handle options in the handle menu
	 */
	@Override
	public void handleMenu() {
		int selected = super.selectOption();
		
		switch (selected) {
			case 0:
				super.setExit(!isExit());
				break;
			case 1:
				if (createOrder()) {
					System.out.println("Order was successfully created.");
				}
				else {
					System.out.println("Order was canceled.");
				}
				break;
		}
	}

	/**
	 * Get info of the orderLine
	 * @return String about the info
	 */
	public String getOrderLineInfo(OrderLine anOrderLine) {
		StringBuilder returnString = new StringBuilder();

		returnString.append(anOrderLine.getAProduct().getName());
		returnString.append("\t" + anOrderLine.getAProduct().getPrice());
		returnString.append(" x" + anOrderLine.getQuantity());
		if(anOrderLine.getQuantity() < 10) {
			returnString.append(" " + anOrderLine.getSubTotal());
		}
		else
		{
			returnString.append(" " + (anOrderLine.getSubTotal() + anOrderLine.getDiscount()));
			returnString.append(" -" + anOrderLine.getQuantity());
			returnString.append(" " + anOrderLine.getSubTotal());
		}
	
		return returnString.toString();
	}
	
	/**
	 * Get receipt of an order
	 * @param anOrder Get receipt of current order
	 * @return String of the receipt
	 */
	public String getOrderReceipt(Order anOrder) {
		StringBuilder returnString = new StringBuilder();
		
		returnString.append("Customer\nName:\t\t");
		returnString.append(anOrder.getACustomer().getName());
		returnString.append("\nPhone number:\t");
		returnString.append(anOrder.getACustomer().getPhoneNumber());
		returnString.append("\n\n");

		returnString.append(getProductsAndPrice(anOrder));
		
		returnString.append("\nDate of purchase:\t");
		returnString.append(anOrder.getDate().getDateTime());
		returnString.append("\n\n");
		
		return returnString.toString();
	}
	
	/**
	 * Get all products and a price of this order line
	 * @return String of all products and a price
	 */
	public String getProductsAndPrice(Order anOrder) {
		StringBuilder returnString = new StringBuilder();
		
		returnString.append(getOrderLineItems(anOrder));
		returnString.append("\n");

		returnString.append("Total:\t" + anOrder.getPrice());
		returnString.append("\n");
		
		return returnString.toString();
	}

	/**
	 * Get info about all items in the order
	 * @return String of the items
	 */
	public String getOrderLineItems(Order anOrder) {
		StringBuilder returnString = new StringBuilder();

		for (OrderLine aLine : anOrder.getOrderLines()) {
			returnString.append(getOrderLineInfo(aLine));
			returnString.append("\n");
		}

		return returnString.toString();
	}

	/**
	 * Cancel Order and return items
	 * @return Items that were cancelled
	 */
	public String cancelOrder(Order anOrder) {
		StringBuilder returnString = new StringBuilder();
		returnString.append("Order Canceled with ");
		returnString.append(anOrder.getOrderLines().size());
		returnString.append(" products:\n");
		
		for (OrderLine aLine : anOrder.getOrderLines()) {
			returnString.append(getOrderLineInfo(aLine));
		}
		
		return returnString.toString();
		
	}

	/**
	 * Create order
	 * @return True if the order was successfully created
	 */
	public boolean createOrder() {
		boolean retVal = false;

		String phone = input.inputString("Enter customer phone number");
		
		if (orderCtrl.createOrder(phone)) {
			String barcode = "";
			int quantity;
			
			while (!barcode.equals("finish")) {
				quantity = 1;
				barcode = input.inputString("Enter product barcode(finish)");
				if (barcode.equals("")) {
					barcode = "finish";
				}
				
				if (!barcode.equals("finish")) {
					quantity = input.inputInt("Enter quantity");
					
					try {
						if (orderCtrl.createOrderline(barcode, quantity)) {
							System.out.println("Product added successfully!");

						}
						else {
							System.out.println("Error, try again.");
						}
					}
					catch (QuantityUnderrunException que) {
						System.out.println(que.getLocalizedMessage());
					}
					catch (ProductNotFound pnf) {
						System.out.println(pnf.getLocalizedMessage());
					}
					
				}
			}
			retVal = makePayment();
		}
		else {
			String m = input.inputString("The phone number doesn't exist in the system, try again or create a new customer profile");
		}
		
		return retVal;
	}
	
	/**
	 * Ask customer to make a payment
	 * @return True if the payment was successful
	 */
	public boolean makePayment() {
		boolean retVal = false;
		if(!orderCtrl.isEmpty()) {
			System.out.println(getProductsAndPrice(orderCtrl.getCurrentOrder()));
			int answer = input.inputInt("Please make a payment. Chose 1 to pay here or 2 for sending an invoice");
			
			if(answer == 1) {
			
				boolean finalized = false;
				
				while(!finalized) {
					String s = input.inputString("Is the payment succesfull? y/n");
					
					if(s.equals("y")) {
						System.out.println("Order succesfully paid");
						try {
							String receipt = getOrderReceipt(orderCtrl.getCurrentOrder());
							orderCtrl.finishOrder();
							System.out.println(receipt);
						}
						catch (EmptyOrder eo) {
							System.out.println(eo.getLocalizedMessage());
							System.out.println(cancelOrder(orderCtrl.getCurrentOrder()));
							orderCtrl.cancelOrder();
						}
					
						finalized = true;
						retVal = true;
					}
					else if(s.equals("n")) {
						System.out.println(cancelOrder(orderCtrl.getCurrentOrder()));
						orderCtrl.getCurrentOrder();
						finalized = true;
					}
					else {
						System.out.println("Payment failed, try again");
					}
				}
			}
			else if(answer == 2){
				String p = input.inputString("Please input CVR");
				// maybe changes later
				System.out.println("Invoice sent");
				retVal = true;
			}
			else {
				System.out.println("Try again");
			}
		}
		return retVal;
	}
}
