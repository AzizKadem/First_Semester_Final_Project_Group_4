package controller;

import model.*;

public class CustomerCtrl {
	
	public CustomerCtrl() {
		
	}
	
	/**
	 * @param phone
	 * @return Customer
	 */
	public static Customer searchCustomer(String phone) {
		return CustomerCont.getInstance().searchCustomer(phone);
	}
}
