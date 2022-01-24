package model;

import java.util.ArrayList;

import exceptions.CustomerNotFoundException;

public final class CustomerCont {
	private static CustomerCont instance;
	private ArrayList<Customer> cust;
	
	private CustomerCont() {
		cust = new ArrayList<>();
	}
	/**
	 * Get instance of the singleton container
	 * @return The instance
	 */
	public static CustomerCont getInstance() {
		if(instance == null) {
			instance = new CustomerCont();
		}
		return instance;
	}
	
	/**
	 * Add a new customer to the customer container
	 * @param newCustomer A new customer to be added to the container
	 * @return True if the customer was added successfully
	 */
	public boolean addCustommer(Customer newCustomer) {
		boolean retVal = false;

		if (cust.add(newCustomer)) {
			retVal = true;
		}
		return retVal;
	}
	
	/**
	 * @param phone
	 * @return Customer
	 * @throws CustomerNotFoundException 
	 */
	public Customer searchCustomer(String phone) throws CustomerNotFoundException {
		boolean found = false;
		Customer retVal = null;
		for(int i=0; !found && i<cust.size(); i++) {
			if(cust.get(i).getPhoneNumber().equals(phone)) {
				retVal = cust.get(i);
				found = true;
			}
		}
		if(retVal == null) {
			throw new CustomerNotFoundException();
		}
		return retVal;
	}
	
	/**
	 * Empty the container
	 */
	public void emptyContainer() {
		cust.clear();
	}
}
