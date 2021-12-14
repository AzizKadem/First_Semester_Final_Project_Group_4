package model;

public class PackageOrderLine extends OrderLine {

	/**
	 * @param quantity
	 */
	public PackageOrderLine(int quantity, Product aProduct) {
		super(quantity, aProduct);
		
		super.calculateSubTotal();
	}

	@Override
	public void subtractFromStock() {
		getAProduct().addToStock(-getQuantity(), null);

	}

	@Override
	public void addToStock() {
		getAProduct().addToStock(getQuantity(), null);

	}
}
