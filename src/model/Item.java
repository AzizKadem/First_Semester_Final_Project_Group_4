package model;

public class Item extends SingleProduct {
	private String barcode;
	private String category;
	
	/**
	 * @param name the name of the item
	 * @param price the price of the item
	 * @param stock the stock which the item has
	 * @param category the category in which the item belongs
	 * @param barcode the barcode of the item
	 */
	public Item(String name, Price price, int stock, String category, String barcode) {
		super(name, price, stock);
		this.barcode = barcode;
		this.category = category;
	}

	/**
	 * Does this item contain the barcode
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
}
