package controller;

import model.*;

public class LeaseCtrl {
	private CustomerCtrl customerController;
	private MachineCtrl machineController;
	private LeaseCont leaseContainer;
	private Lease lease;
	
	public LeaseCtrl() {
		
	}
	
	public Customer searchCustomer(String phone) {
		customerController = new CustomerCtrl();
		return customerController.searchCustomer(phone);
	}
	
	public Machine searchMachine(int id) {
		machineController = new MachineCtrl();
		return machineController.searchMachine(id);
	}
	
	public boolean confirmLease(Customer c, Machine m) {
		Lease l = new Lease(c, m);
		return leaseContainer.getInsatnce().addLease(l);
	}
}
