package controller;

import model.*;
;

public class StaffCtrl {
	private Staff loged;	
	
	public StaffCtrl() {
		//for now
		loged = new Staff(0, "worker", "1234");
	}
	
	/**
	 * @param amount
	 */
	public void addTotal(double amount) {
		loged.updateTotal(amount);
	}
}
