package model;

public class ItemsOrderLine extends OrderLine {
	private Product aProduct;

	public ItemsOrderLine(int quantity, Product aProduct) {
		super(quantity);
		this.aProduct = aProduct;
		
		super.calculateSubTotal();
	}

	@Override
	public Product getAProduct() {
		return aProduct;
	}

}
