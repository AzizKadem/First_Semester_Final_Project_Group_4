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

	/**
	 * Get a product
	 * 
	 * @return A product as Product
	 */
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

	/**
	 * Subtract a quantity from stock
	 */
	@Override
	public void subtractFromStock() {
		copy.setStock(copy.getStock() - super.getQuantity());
	}

	/**
	 * Add a quantity to the stock
	 */
	@Override
	public void addToStock() {
		copy.setStock(copy.getStock() + super.getQuantity());
		
	}
}
