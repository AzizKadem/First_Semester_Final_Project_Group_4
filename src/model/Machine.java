package model;

public class Machine {
	private String name;
	private int ID;

	public Machine(int ID, String name) {
		this.name = name;
		this.ID = ID;
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
}
