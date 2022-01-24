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
	
	/**
	 * Prints lease info
	 */
	public void printLeaseInfo() {
		
		System.out.println("Lease of " + m.getName() + " for a period of " + period + " month(s)");
		System.out.println("Price: " + period * m.getPrice());
		System.out.println("Date: " + date.getDateTime());
	}
	
	/**
	 * @return machineID
	 */
	public int getMachineId() {
		return m.getID();
	}
	
	/**
	 * @return Machine
	 */
	public Machine getMachine() {
		return m;
	}

	/**
	 * @return the period
	 */
	public int getPeriod() {
		return period;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the c
	 */
	public Customer getCustomer() {
		return c;
	}
}
