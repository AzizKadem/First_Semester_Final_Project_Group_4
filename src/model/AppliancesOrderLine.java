package model;

public class AppliancesOrderLine extends OrderLine {
	private String details;
	private ApplianceCopy copy;
	private Product product;
	
	public AppliancesOrderLine(int quantity, Product aProduct, String barcode) {
		super(quantity);
		product = aProduct;
		copy = ((Appliance)product).getCopyByBarcode(barcode);
		
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

	@Override
	public Product getAProduct() {
		return product;
	}

	/**
	 * Get copy
	 * 
	 * @return copy as ApplianceCopy
	 */
	public ApplianceCopy getCopy() {
		return copy;
	}
}
