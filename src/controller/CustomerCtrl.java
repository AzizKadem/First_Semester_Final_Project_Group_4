package controller;

import model.*;

public class CustomerCtrl {
	private CustomerCont cont;
	
	public CustomerCtrl() {
		
	}
	
	public Customer searchCustomer(String phone) {
		return cont.getInstance().searchCustomer(phone);
	}
}
