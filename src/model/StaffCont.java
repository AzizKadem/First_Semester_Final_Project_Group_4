package model;

import java.util.ArrayList;

public final class StaffCont {
	private ArrayList<Staff> staff;
	private static StaffCont instance;
	
	public StaffCont() {
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
}
