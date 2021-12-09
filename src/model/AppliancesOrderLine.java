package model;

public class AppliancesOrderLine extends OrderLine{
	private String details;
	
	public AppliancesOrderLine(String details, int quantity, Product aProduct) {
		// TODO Auto-generated constructor stub
		super(quantity, aProduct);
		this.details = details;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

}
