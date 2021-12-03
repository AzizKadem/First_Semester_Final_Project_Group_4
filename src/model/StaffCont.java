package model;

import java.util.ArrayList;

public final class StaffCont {
	private ArrayList<Staff> staff;
	private static CustomerCont instance;
	
	public StaffCont() {
		staff = new ArrayList<>();
	}
	
	public static CustomerCont getInstance() {
		if(instance == null) {
			instance = new StaffCont();
		}
		return instance;
	}
}
