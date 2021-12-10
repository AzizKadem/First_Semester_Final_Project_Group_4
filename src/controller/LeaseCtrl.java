package controller;

import model.*;

public class LeaseCtrl {
	private CustomerCtrl customerController;
	private MachineCtrl machineController;
	
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
	
	public Lease searchLease(int id) {
		return LeaseCont.getInsatnce().searchLease(id);
	}
	
	public boolean confirmLease(Customer c, Machine m) {
		Lease l = new Lease(c, m);
		m.setLease(true);
		return LeaseCont.getInsatnce().addLease(l);
	}
	
	public boolean removeLease(Lease l) {
		l.getMachine().setLease(true);
		return LeaseCont.getInsatnce().removeLease(l);
	}
}
