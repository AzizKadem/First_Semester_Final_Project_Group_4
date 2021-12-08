package ui;

import javax.print.DocFlavor.INPUT_STREAM;

import Exceptions.EmptyOrder;
import Exceptions.ProductNotFound;
import Exceptions.QuantityUnderrunException;
import controller.OrderCtrl;

public class OrderMenu extends Menu {
	private OrderCtrl orderCtrl;
	private TextInput input;

	public OrderMenu() {
		super("Order Menu", "Back");
		super.addOption("Create Order");
		super.addOption("Print");

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
			case 2:
				System.out.println(" " + orderCtrl.printAllOrders());
				break;
		}
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
		
		return retVal;
	}
	
	public boolean makePayment() {
		boolean retVal = false;
		if(!orderCtrl.isEmpty()) {
			System.out.println(orderCtrl.getProductsAndPrice());
			int answ = input.inputInt("Please make a payment. Chose 1 to pay here or 2 for sending an invoice");
			
			if(answ == 1) {
			
				boolean finalized = false;
				
				while(!finalized) {
					String s = input.inputString("Is the payment succesfull? y/n");
					
					if(s.equals("y")) {
						System.out.println("Order succesfully paid");
						try {
							System.out.println(orderCtrl.finishOrder());
						}
						catch (EmptyOrder eo) {
							System.out.println(eo.getLocalizedMessage());
							System.out.println(orderCtrl.cancelOrder());
						}
					
						finalized = true;
						retVal = true;
					}
					else if(s.equals("n")) {
						System.out.println(orderCtrl.cancelOrder());
						finalized = true;
					}
					else {
						System.out.println("Payment failed, try again");
					}
				}
			}
			else if(answ == 2){
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
