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

	/**
	 * Get name.
	 *
	 * @return name as String.
	 */
	public String getName() {
	    return name;
	}

	/**
	 * Set name.
	 *
	 * @param name the value to set.
	 */
	public void setName(String name) {
	    this.name = name;
	}

	/**
	 * Get ID.
	 *
	 * @return ID as int.
	 */
	public int getID() {
	    return ID;
	}

	/**
	 * Set ID.
	 *
	 * @param ID the value to set.
	 */
	public void setID(int ID) {
	    this.ID = ID;
	}

	/**
	 * Get price.
	 *
	 * @return price as double.
	 */
	public double getPrice() {
	    return price;
	}

	/**
	 * Set price.
	 *
	 * @param price the value to set.
	 */
	public void setPrice(double price) {
	    this.price = price;
	}

	/**
	 * Get leased.
	 *
	 * @return leased as boolean.
	 */
	public boolean isLeased() {
	    return leased;
	}

	/**
	 * Set leased.
	 *
	 * @param leased the value to set.
	 */
	public void setLeased(boolean leased) {
	    this.leased = leased;
	}
}
