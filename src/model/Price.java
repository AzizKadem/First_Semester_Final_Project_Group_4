package model;

public class Price {

	private String period;
	private double price;
	
	/**
	 * Price constructor
	 * @param period the period in which the price was active
	 * @param price the price of the product in DKK
	 */
	public Price(String period, double price) {
		super();
		this.period = period;
		this.price = price;
	}

	/**
	 * Get the period
	 * 
	 * @return the period
	 */
	public String getPeriod() {
		return period;
	}

	/**
	 * Get the price
	 * 
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
}
