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
		getAProduct().setStock(-getQuantity());

	}

	@Override
	public void addToStock() {
		getAProduct().setStock(getQuantity());

	}
}
