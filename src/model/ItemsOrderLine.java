package model;

public class ItemsOrderLine extends OrderLine {
	public ItemsOrderLine(int quantity, Product aProduct) {
		super(quantity, aProduct);
		
		super.calculateSubTotal();
	}

	@Override
	public void subtractFromStock() {
		getAProduct().setStock(getAProduct().getStock() - getQuantity());
	}

	@Override
	public void addToStock() {
		getAProduct().setStock(getAProduct().getStock() + getQuantity());
	}

}
