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
	
	public Lease searchLease(int id) {
		boolean found = false;
		Lease retVal = null;
		for(int i = 0; i < leases.size() || !found; i++ ) {
			if(leases.get(i).getMachineId(id) == id) {
				found = true;
				retVal = leases.get(i);
			}
		}
		return retVal;
	}
	
	public boolean removeLease(Lease l) {
		return leases.remove(l);
	}
	
	public int getContainerSize() {
		return leases.size();
	}
	
	public void emptyContainer() {
		for(Lease element: leases) {
			leases.remove(element);
		}
	}
}
