package ui;

import controller.OrderCtrl;

public class OrderMenu extends Menu {
	private OrderCtrl orderCtrl;
	private TextInput input;

	public OrderMenu() {
		super("Back");
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
					while(quantity < 1) {
						quantity = input.inputInt("Quantity cannot be negative, try again");
					}

					if (orderCtrl.createOrderline(barcode, quantity)) {
						System.out.println("Product added successfully!");

					}
					else {
						System.out.println("Error, try again.");
					}
				}
			}
			//TODO ask for payment first
			//Empty order can be created!
			System.out.println(orderCtrl.calculatePrice());
			retVal = true;
		}
		return retVal;
	}

}
