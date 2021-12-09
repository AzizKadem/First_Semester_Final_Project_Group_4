package model;

public class BusinessCustomer extends Customer{
	private String companyName;
	
	private double businessDiscount;
	
	public BusinessCustomer(String name, String phoneNumber, String address, String city, String zipCode) {
		// TODO Auto-generated constructor stub
		super(name, phoneNumber, address, city, zipCode);
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the businessDiscount
	 */
	public double getBusinessDiscount() {
		return businessDiscount;
	}

	/**
	 * @param businessDiscount the businessDiscount to set
	 */
	public void setBusinessDiscount(double businessDiscount) {
		this.businessDiscount = businessDiscount;
	}

}
