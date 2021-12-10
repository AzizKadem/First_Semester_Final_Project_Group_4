package model;

public class Item extends Product {
	private String barcode;
	private String category;
	private int stock;
	
	public Item(String name, Price price, int stock, String category, String barcode) {
		super(name, price);
		this.barcode = barcode;
		this.category = category;
		this.stock = stock;
	}

	/**
	 * Does this item contains the barcode
	 * @param barcode The barcode to match
	 * @return True if the barcode is the same
	 */
	@Override
	public boolean isWithBarcode(String barcode) {
		boolean retVal = false;
		if (this.barcode.equals(barcode)) {
			retVal = true;
		}
		return retVal;
	}

	@Override
	public int getStock() {
		return stock;
	}

	@Override
	public void setStock(int stock) {
		this.stock = stock;
	}

}
