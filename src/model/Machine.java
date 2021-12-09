package model;

public class Machine {
	private String name;
	private int ID;
	private boolean leased;

	public Machine(int ID, String name) {
		this.name = name;
		this.ID = ID;
		leased = false;
		
	}

	/**
	 * @return ID
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param l
	 */
	public void setLease(boolean l) {
		leased = l;
	}
	
	/**
	 * @return leased
	 */
	public boolean isLeased() {
		return leased;
	}
}
