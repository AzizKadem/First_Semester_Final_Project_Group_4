package model;

import java.util.ArrayList;

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
	 * @param phone
	 * @return Customer
	 */
	public Customer searchCustomer(String phone) {
		boolean found = false;
		Customer retVal = null;
		for(int i=0; !found && i<cust.size(); i++) {
			if(cust.get(i).getPhoneNumber() == phone) {
				retVal = cust.get(i);
			}
		}
		return retVal;
	}
}
