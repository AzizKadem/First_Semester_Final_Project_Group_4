package ui;

import controller.OrderCtrl;
import exceptions.EmptyOrderException;
import exceptions.NotEnoughInStockException;
import exceptions.ProductNotFoundException;
import exceptions.QuantityUnderrunException;
import model.Appliance;
import model.AppliancesOrderLine;
import model.Order;
import model.OrderLine;

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
		if (anOrderLine.getQuantity() < 10) {
			returnString.append(" " + anOrderLine.getSubTotal());
		}
		else {
			returnString.append(" " + (anOrderLine.getSubTotal() + anOrderLine.getDiscount()));
			returnString.append(" -" + anOrderLine.getQuantity());
			returnString.append(" " + anOrderLine.getSubTotal());
		}
		
		if (anOrderLine.getAProduct().getClass().isAssignableFrom(Appliance.class)) {
			returnString.append("\n\tColor: ");
			returnString.append(((AppliancesOrderLine)anOrderLine).getCopy().getColor());
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
	 * Select how what is the customer
	 * @return selected customer type as int
	 */
	public int handleCustomer() {
		Menu menu = new PlaceholderMenu("Customer", "Cancel");
		menu.addOption("Existing customer");
		menu.addOption("New customer");
		menu.addOption("Continue as guest");
		
		return menu.selectOption();
	}

	/**
	 * Create order
	 * @return True if the order was successfully created
	 */
	public boolean createOrder() {
		boolean retVal = false;
		
		int cust = handleCustomer();
		
		String phone = "";

		switch (cust) {
			case 1:
				phone = input.inputString("Enter customer phone number");
				
				
				break;
			case 2:
				//create new customer
				break;
			case 3:
				//make a guest with unique id
				break;
				
			
		}
		
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
					catch (ProductNotFoundException pnfe) {
						System.out.println(pnfe.getLocalizedMessage());
					}
					catch (NotEnoughInStockException neise) {
						System.out.println(neise.getLocalizedMessage());
					}
					
				}
			}
			retVal = makePayment();
		}
		else {
			System.out.println("The customer was not found");
		}
		
		return retVal;
	}
	
	public int paymentType() {
		Menu menu = new PlaceholderMenu("Payment", "Cancel");
		menu.addOption("Pay here");
		menu.addOption("Send invoice");
		
		return menu.selectOption();
	}
	
	/**
	 * Ask customer to make a payment
	 * @return True if the payment was successful
	 */
	public boolean makePayment() {
		boolean retVal = false;
		if(!orderCtrl.isEmpty()) {
			System.out.println(getProductsAndPrice(orderCtrl.getCurrentOrder()));
			int answer = paymentType();
			
			switch (answer) {
				case 1:
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
							catch (EmptyOrderException eo) {
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
					break;
				case 2:
					String p = input.inputString("Please input CVR");
					// maybe changes later
					System.out.println("Invoice sent");
					retVal = true;
					break;
				default:
					System.out.println(cancelOrder(orderCtrl.getCurrentOrder()));
					orderCtrl.cancelOrder();
					break;
			}
		}
		return retVal;
	}
}
