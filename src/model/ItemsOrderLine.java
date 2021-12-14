package model;

public class ItemsOrderLine extends OrderLine {

	public ItemsOrderLine(int quantity, Product aProduct) {
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
