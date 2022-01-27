package model;

import java.util.ArrayList;

public final class StaffCont {
	private ArrayList<Staff> staff;
	private static StaffCont instance;
	
	private StaffCont() {
		staff = new ArrayList<>();
	}
	/**
	 * Get instance of the singleton container
	 * @return The instance
	 */
	public static StaffCont getInstance() {
		if(instance == null) {
			instance = new StaffCont();
		}
		return instance;
	}

	/**
	 * Get staff.
	 *
	 * @return staff as ArrayList<Staff>.
	 */
	public ArrayList<Staff> getStaffList() {
	    return staff;
	}

	/**
	 * Find staff with userName and password
	 * @param userName The name of the user
	 * @param password The coresponding password 
	 * @return Staff found staff
	 */
	public Staff getStaffLogin(String userName, String password) {
		boolean found = false;
		Staff retVal = null;
		int index = 0;

		while (index < staff.size() && !found) {
			Staff thisStaff = staff.get(index);

			if (thisStaff.checkLogIn(userName, password)) {
				retVal = thisStaff;
				found = true;
			}
			else {
				index++;
			}
		}

		return retVal;
	}
}
