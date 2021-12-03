package controller;

import model.*;

public class CustomerCtrl {
	
	public CustomerCtrl() {
		
	}
	
	public Customer searchCustomer(String phone) {
		return CustomerCont.getInstance().searchCustomer(phone);
	}
}
