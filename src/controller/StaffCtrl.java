package controller;

import model.Staff;

public class StaffCtrl {
	private Staff loged;	
	
	public StaffCtrl() {
		//for now
		loged = new Staff(0, "worker", "1234");
	}
	
	/**
	 * Add a total amount to the staff
	 * @param amount The amount to be added
	 */
	public void addTotal(double amount) {
		loged.updateTotal(amount);
	}
}
