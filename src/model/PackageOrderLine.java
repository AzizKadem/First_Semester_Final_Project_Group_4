package model;

public class PackageOrderLine extends OrderLine {
	private Product aProduct;

	/**
	 * @param quantity
	 */
	public PackageOrderLine(int quantity, Product aProduct) {
		super(quantity);
		this.aProduct = aProduct;
		
		super.calculateSubTotal();
	}

	@Override
	public void subtractFromStock() {
		aProduct.setStock(-super.getQuantity());

	}

	@Override
	public void addToStock() {
		aProduct.setStock(super.getQuantity());

	}

	@Override
	public Product getAProduct() {
		return aProduct;
	}

}
