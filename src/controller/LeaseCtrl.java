package controller;

import exceptions.CustomerNotFoundException;
import exceptions.MachineNotFoundException;
import model.Customer;
import model.Lease;
import model.LeaseCont;
import model.Machine;

public class LeaseCtrl {
	private CustomerCtrl customerController;
	private MachineCtrl machineController;
	
	public LeaseCtrl() {
		
	}
	
	/**
	 * Search customer by phone number
	 * @param phone The phone number the customer is searched by
	 * @return found customer
	 * @throws CustomerNotFoundException 
	 */
	public Customer searchCustomer(String phone) throws CustomerNotFoundException {
		customerController = new CustomerCtrl();
		return customerController.searchCustomer(phone);
	}
	
	/**
	 * Search machine by id
	 * @param id The id the machine is searched by
	 * @return found machine
	 * @throws MachineNotFoundException 
	 */
	public Machine searchMachine(int id) throws MachineNotFoundException {
		machineController = new MachineCtrl();
		return machineController.searchMachine(id);
	}
	
	/**
	 * Search lease by id
	 * @param id The id the lease is searched by
	 * @return found lease
	 */
	public Lease searchLease(int id) {
		return LeaseCont.getInstance().searchLease(id);
	}
	
	/**
	 * Confirm lease with customer and machine
	 * @param c A customer who is leasing
	 * @param m A machine that is being leased
	 * @return True if the lease was successful
	 */
	public boolean confirmLease(Customer c, Machine m) {
		Lease l = new Lease(c, m);
		m.setLeased(true);
		return LeaseCont.getInstance().addLease(l);
	}
	
	/**
	 * Remove existing lease
	 * @param l A lease to be removed
	 * @return True if the lease was removed successfully
	 */
	public boolean removeLease(Lease l) {
		l.getMachine().setLeased(true);
		return LeaseCont.getInstance().removeLease(l);
	}
}
