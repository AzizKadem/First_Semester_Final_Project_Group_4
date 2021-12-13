package ui;

import controller.LeaseCtrl;
import model.Lease;

public class LeaseMenu extends Menu{
	private LeaseCtrl leaseCtrl;
	private TextInput input;
	
	public LeaseMenu() {
		super("Lease Menu", "Back");
		super.addOption("Create Lease");
		super.addOption("Return lease");
		
		leaseCtrl = new LeaseCtrl();
		input = new TextInput();
	}
	
	@Override
	public void handleMenu() {
		int selected = super.selectOption();
		
		switch (selected) {
			case 0:
				super.setExit(!isExit());
				break;
			case 1:
				if(createLease()) {
					System.out.println("Lease created!");
				}
				else {
					System.out.println("Lease canceled");
				}
				break;
			case 2:
				returnLease(input.inputInt("Input Machine ID"));
				break;
		}
	}
	
	/**
	 * Handle creating lease
	 * @return True if the lease was created succesfully
	 */
	public boolean createLease() {
		boolean retVal = false;
		
		String phone = input.inputString("Enter customer phone");
		
		if(leaseCtrl.searchCustomer(phone) != null) {
			int id;
		
			id = input.inputInt("Enter product id");
			if(leaseCtrl.searchMachine(id) != null){
			//TODO print info about the product!!
				String conf = input.inputString("Would you like to confirm the lease? y/n");
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
	
	/**
	 * Handle returning of the lease
	 * @param machineID The machine id
	 * @return True if the returning was successful
	 */
	public boolean returnLease(int machineID) {
		boolean retVal = false;
		Lease l = leaseCtrl.searchLease(machineID);
		if(leaseCtrl.searchLease(machineID) != null) {
			System.out.println("Lease found");
			l.printLeaseInfo();
			//display info about lease
			String answ = input.inputString("Confirm return of the machine y/n");
			if(answ.equals("y")) {
				l.getMachine().setLeased(false);
				leaseCtrl.removeLease(l);
				retVal = true;
				System.out.println("Machine returned succesfully");
			}
			else {
				System.out.println("Machine not returned");
			}
		}
		else {
			System.out.println("System was not able to find the lease, try again!");
		}
		return retVal;
	}
}
