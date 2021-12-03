package controller;

import model.*;
;

public class StaffCtrl {
	private Staff loged;	
	
	public StaffCtrl() {
		
	}
	
	/**
	 * @param amount
	 */
	public void addTotal(double amount) {
		loged.updateTotal(amount);
	}
}
