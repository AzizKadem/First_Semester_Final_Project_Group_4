package model;

import java.util.ArrayList;

public class LeaseCont {
	private ArrayList<Lease> leases;
	private LeaseCont instance;

	private LeaseCont() {
		
	}
	
	public LeaseCont getInsatnce() {
		if (instance == null) {
			instance = new LeaseCont();
		}
		return instance;
	}
	
	public boolean addLease(Lease newLease) {
		boolean retVal = false;
		if(!leases.contains(newLease)) {
			retVal = true;
			leases.add(newLease);
		}
		return retVal;
	}
}
