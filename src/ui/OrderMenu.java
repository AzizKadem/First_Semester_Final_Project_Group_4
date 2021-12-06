package ui;

import Exceptions.ProductNotFound;
import Exceptions.QuantityUnderrunException;
import controller.OrderCtrl;

public class OrderMenu extends Menu {
	private OrderCtrl orderCtrl;
	private TextInput input;

	public OrderMenu() {
		super("Back");
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
				if (createOrder() && orderCtrl.isEmpty() == false) {
					System.out.println("Order was successfully created.");
				}
				break;
			case 2:
				System.out.println(" " + orderCtrl.printInfo());
				break;
		}
	}
	
	/**
	 * Create order
	 * @return True if the order was successfully created
	 */
	public boolean createOrder() {
		boolean retVal = false;

		String phone = input.intupString("Enter customer phone number");
		
		if (orderCtrl.createOrder(phone)) {
			String barcode = "";
			int quantity;
			
			while (!barcode.equals("finish")) {
				quantity = 1;
				barcode = input.intupString("Enter product barcode(finish)");
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
			//TODO ask for payment first
			//Empty order can be created!
			if(!orderCtrl.isEmpty())
			{
				System.out.println(orderCtrl.finishOrder());
				System.out.println("Please make a payment(sending signal to the card treminal)");
				boolean finalized = false;

				while(finalized = true) {
				String s = input.intupString("Is the payment succesfull? y/n");

					if(s.equals("y")) {
						System.out.println("Order succesfully finalized");
						System.out.println(orderCtrl.finishOrder());
						finalized = true;
					}
					else if(s.equals("n")) {
						System.out.println("The order is cancelled");
						finalized = false;
					}
					else {
						System.out.println("Payment failed, try again");
					}
				retVal = true;
			}
			
		}
		}
		return retVal;
	}
}