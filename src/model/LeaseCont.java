package model;

import java.util.ArrayList;

public final class LeaseCont {
	private ArrayList<Lease> leases;
	private static LeaseCont instance;

	private LeaseCont() {
		leases = new ArrayList<>();
	}
	
	/**
	 * Get instance of the lease container
	 * @return Instance of the container
	 */
	public static LeaseCont getInstance() {
		if (instance == null) {
			instance = new LeaseCont();
		}
		return instance;
	}
	
	/**
	 * Add a lease to the container
	 * @param newLease A lease to be added
	 * @return True if the lease was added successfully
	 */
	public boolean addLease(Lease newLease) {
		boolean retVal = false;
		if(!leases.contains(newLease)) {
			retVal = true;
			leases.add(newLease);
		}
		return retVal;
	}
	
	/**
	 * Search for a lease by id
	 * @param id The id the lease is searched by
	 * @return Found lease, null if not found
	 */
	public Lease searchLease(int id) {
		boolean found = false;
		Lease retVal = null;
		for(int i = 0; i < leases.size() && !found; i++ ) {
			if(leases.get(i).getMachineId() == id) {
				found = true;
				retVal = leases.get(i);
			}
		}
		return retVal;
	}
	
	/**
	 * Remove a lease from the container
	 * @param l A lease to be removed
	 * @return True if the lease was removed successfully
	 */
	public boolean removeLease(Lease l) {
		return leases.remove(l);
	}
	
	/**
	 * Returns amount of the leases stored in the container
	 * 
	 * @return container size as int
	 */
	public int getContainerSize() {
		return leases.size();
	}
	
	/**
	 * Empty the container
	 */
	public void emptyContainer() {
		for(Lease element: leases) {
			leases.remove(element);
		}
	}
}
