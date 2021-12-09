package model;

public class CasualCustomer extends Customer{
	private double discount;
	
	public CasualCustomer (String name, String phoneNumber, String address, String city, String zipCode) {
		// TODO Auto-generated constructor stub
		super(name, phoneNumber, address, city, zipCode);
	}

	/**
	 * @return the discount
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
