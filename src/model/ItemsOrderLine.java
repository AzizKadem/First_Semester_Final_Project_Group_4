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

	@Override
	public void subtractFromStock() {
		getAProduct().setStock(getAProduct().getStock() - super.getQuantity());
	}

	@Override
	public void addToStock() {
		getAProduct().setStock(getAProduct().getStock() + super.getQuantity());
	}

}
