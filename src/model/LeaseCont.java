package model;

import java.util.ArrayList;

public final class LeaseCont {
	private ArrayList<Lease> leases;
	private static LeaseCont instance;

	private LeaseCont() {
		leases = new ArrayList<>();
	}
	
	public static LeaseCont getInsatnce() {
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
