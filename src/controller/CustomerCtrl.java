package controller;

import exceptions.CustomerNotFoundException;
import model.*;

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
}
