package controller;

import model.Staff;
import model.StaffCont;
import java.util.ArrayList;

public class StaffCtrl {
	private static Staff loged;	
	
	public StaffCtrl() {
		//for now
		loged = new Staff(0, "worker", "1234", "admin", "password", true);
	}
	
	/**
	 * Add a total amount to the staff
	 * @param amount The amount to be added
	 */
	public void addTotal(double amount) {
		loged.updateTotal(amount);
	}

	/**
	 * Log in to the system
	 * @param userName The user name of the staff
	 * @param password The password of the staff
	 * @return True if the log in information was correct
	 */
	public boolean logIn(String userName, String password) {
		boolean retVal = false;
		Staff staff = StaffCont.getInstance().getStaffLogin(userName, password);

		if (staff != null) {
			loged = staff;
			retVal = true;
		}

		return retVal;
	}

	/**
	 * Get list of all staff
	 * @return ArrayList<Staff> List of all staff
	 */
	public ArrayList<Staff> getStaffList() {
		return StaffCont.getInstance().getStaffList();
	}
}
