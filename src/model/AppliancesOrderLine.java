package model;

public class AppliancesOrderLine extends OrderLine {
	private String details;
	private ApplianceCopy copy;
	
	public AppliancesOrderLine(int quantity, Product aProduct, String barcode) {
		super(quantity, aProduct);
		copy = ((Appliance)super.getAProduct()).getCopyByBarcode(barcode);
		
		super.calculateSubTotal();
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

	/**
	 * Get copy
	 * 
	 * @return copy as ApplianceCopy
	 */
	public ApplianceCopy getCopy() {
		return copy;
	}

	/**
	 * Subtract a quantity from stock
	 */
	@Override
	public void subtractFromStock() {
		getAProduct().addToStock(-getQuantity(), copy);
	}

	/**
	 * Add a quantity to the stock
	 */
	@Override
	public void addToStock() {
		getAProduct().addToStock(getQuantity(), copy);	
	}
}
