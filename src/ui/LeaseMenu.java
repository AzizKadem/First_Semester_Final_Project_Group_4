package ui;

import controller.LeaseCtrl;

public class LeaseMenu extends Menu{
	private LeaseCtrl leaseCtrl;
	private TextInput input;
	
	public LeaseMenu() {
		super("Lease Menu", "Back");
		super.addOption("Create Lease");
		
		leaseCtrl = new LeaseCtrl();
		input = new TextInput();
	}
	
	@Override
	public void handleMenu() {
		int selected = super.selectOption();
		
		switch (selected) {
			case 0:
				super.setExit(isExit());
				break;
			case 1:
				if(createLease()) {
					System.out.println("Lease created!");
				}
				else {
					System.out.println("Lease canceled");
				}
				break;
		}
	}
	
	public boolean createLease() {
		boolean retVal = false;
		
		String phone = input.intupString("Enter customer phone");
		
		if(leaseCtrl.searchCustomer(phone) != null) {
			int id;
		
			id = input.inputInt("Enter product id");
			if(leaseCtrl.searchMachine(id) != null){
			//TODO print info about the product!!
				String conf = input.intupString("Would you like to confirm the lease? y/n");
				if(conf.equals("y")) {
					retVal = leaseCtrl.confirmLease(leaseCtrl.searchCustomer(phone), leaseCtrl.searchMachine(id));
				}
				else {
					System.out.println("Lease cancelled");
				}
			}
			else {
				System.out.println("Barcode not found, try again");
			}
		}
		else {
			System.out.println("Customer not found, try again");
		}
		return retVal;
	}
}
