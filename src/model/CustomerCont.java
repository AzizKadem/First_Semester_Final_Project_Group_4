package model;

import java.util.ArrayList;

public final class CustomerCont {
	private static CustomerCont INSTANCE;
	private ArrayList<Customer> cust;
	
	private CustomerCont() {
		cust = new ArrayList<>();
	}
	
	public static CustomerCont getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new CustomerCont();
		}
		return INSTANCE;
	}
	
	public Customer searchCustomer(String phone) {
		for(Customer element: cust) {
			if(element.getPhoneNumber() == phone) {
				return element;
			}
			else {
				return null;
			}
		}
	}
}
