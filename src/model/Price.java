package model;

public class Price {

	private Date date;
	private double price;
	
	/**
	 * Price constructor
	 * @param period the period in which the price was active
	 * @param price the price of the product in DKK
	 */
	public Price(Date date, double price) {
		super();
		this.date = date;
		this.price = price;
	}

	/**
	 * Get the period
	 * 
	 * @return the period
	 */
	public Date getDate() {
		return date;
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
