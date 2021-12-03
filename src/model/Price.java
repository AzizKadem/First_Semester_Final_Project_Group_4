package model;

public class Price {

	private String period;
	private double price;
	
	/**
	 * @param period
	 * @param price
	 */
	public Price(String period, double price) {
		super();
		this.period = period;
		this.price = price;
	}

	/**
	 * @return the period
	 */
	public String getPeriod() {
		return period;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
}
