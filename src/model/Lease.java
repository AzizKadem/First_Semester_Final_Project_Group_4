package model;

public class Lease {
	private int period;
	private double price;
	private String date;
	private Customer c;
	private Machine m;
	
	public Lease(Customer c, Machine m) {
		this.c = c;
		this.m = m;
	}
	
	public void printLeaseInfo() {
		System.out.println("Lease of " + m.getName() + " for a period of " + period);
	}
}
