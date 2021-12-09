package model;

public class Lease {
	private int period;
	private Date date;
	private Customer c;
	private Machine m;
	
	public Lease(Customer c, Machine m) {
		this.c = c;
		this.m = m;
		date = new Date();
		period = 1;
	}
	
	public void printLeaseInfo() {
		
		System.out.println("Lease of " + m.getName() + " for a period of " + period + " month(s)");
		System.out.println("Price: " + period*m.getPrice());
		System.out.println("Date: " + date.getDateTime());
	}
	
	public int getMachineId(int id) {
		return m.getID();
	}
	
	public Machine getMachine() {
		return m;
	}
}
