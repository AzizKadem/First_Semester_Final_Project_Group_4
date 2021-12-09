package model;

public class Machine {
	private String name;
	private int ID;
	private double price;
	private boolean leased;

	public Machine(int ID, String name) {
		this.name = name;
		this.ID = ID;
		leased = false;
		price = 100;
		
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double p) {
		price = p;
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
