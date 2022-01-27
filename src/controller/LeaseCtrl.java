package controller;

import exceptions.CustomerNotFoundException;
import exceptions.LeaseNotFoundException;
import exceptions.MachineAlreadyLeasedException;
import exceptions.MachineNotFoundException;
import exceptions.NotCorrectCustomerException;
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
	 * @throws NotCorrectCustomerException 
	 * @throws LeaseNotFoundException 
	 */
	public Lease searchLease(Customer c, int id) throws NotCorrectCustomerException, LeaseNotFoundException {
		Lease lease = LeaseCont.getInstance().searchLease(id);
		
		if(!LeaseCont.getInstance().checkForCustomer(c, lease))
		{
			throw new NotCorrectCustomerException();
		}
		
		return lease;
	}
	
	/**
	 * Confirm lease with customer and machine
	 * @param c A customer who is leasing
	 * @param m A machine that is being leased
	 * @return True if the lease was successful
	 * @throws MachineAlreadyLeasedException 
	 */
	public boolean confirmLease(Customer c, Machine m) throws MachineAlreadyLeasedException {
		boolean retVal;
		if(!m.isLeased()) {
			Lease l = new Lease(c, m);
			m.setLeased(true);
			retVal = LeaseCont.getInstance().addLease(l);
		}
		else {
			throw new MachineAlreadyLeasedException();
		}
		return retVal;
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
