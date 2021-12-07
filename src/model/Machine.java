package model;

public class Machine {
	private String name;
	private int ID;
	
	public Machine(int ID, String name) {
		this.name = name;
		this.ID = ID;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getName() {
		return name;
	}
}
