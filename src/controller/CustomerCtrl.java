package controller;

import java.util.ArrayList;

import exceptions.CustomerNotFoundException;
import model.Customer;
import model.CustomerCont;

public class CustomerCtrl {
	
	public CustomerCtrl() {
		
	}
	
	/**
	 * @param phone
	 * @return Customer
	 * @throws CustomerNotFoundException 
	 */
	public Customer searchCustomer(String phone) throws CustomerNotFoundException {
		return CustomerCont.getInstance().searchCustomer(phone);
	}

	/**
	 * Create a new customer
	 * @return True if the creation was successful
	 */
	public boolean createNewCustomer(String name, String phoneNumber,
			String address, String city, String zipCode) {
		boolean retVal = false;

		Customer newCustomer = new Customer(name, phoneNumber, address, city, zipCode);

		if (CustomerCont.getInstance().addCustomer(newCustomer)) {
			retVal = true;
		}

		return retVal;
	}
	
	/**
	 * @return a list of customers
	 */
	public ArrayList<Customer> getCustomers() {
		return CustomerCont.getInstance().getCustomerList();
	}
}
