package controller;

import model.*;

public class LeaseCtrl {
	private CustomerCtrl customerController;
	private MachineCtrl machineController;
	private LeaseCont leaseContainer;
	
	public LeaseCtrl() {
		
	}
	
	public Customer searchCustomer(String phone) {
		return customerController.searchCustomer(phone);
	}
	
	public Machine searchMachine(int id) {
		return machineController.searchMachine(id);
	}
	
	public boolean confirmLease(Lease newLease) {
		return leaseContainer.getInsatnce().addLease(newLease);
	}
}
