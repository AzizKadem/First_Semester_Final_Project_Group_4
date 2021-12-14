	package model;

public abstract class SingleProduct extends Product{
	
	//private Department department;
	
	/**
	 * SingleProduct constructor
	 * @param name the name of the product
	 * @param price the price of the product
	 */
	public SingleProduct(String name, Price price) {
		super(name, price);
	}
	
	/**
	 * Check if the stock has amount
	 * @param amount The amount of items to be compared
	 * @return True if stock has enough items
	 */
	@Override
	public boolean isEnoughInStock(int amount) {
		boolean retVal = false;
		if ((getStock() - amount) >= 0) {
			retVal = true;
		}
		return retVal;
	}
	
	/**
	 * Does this single product contain the barcode
	 * @param barcode The barcode to match
	 * @return True if the barcode is the same
	 */
	public abstract boolean isWithBarcode(String barcode);

	/**
	 * Change the current price.
	 *  
	 * @param newPrice the new of the product
	 * @return true if the change was successful
	 */
	public boolean changePrice(Price newPrice) {
		return getPrices().add(newPrice);
	}
	
	@Override
	public abstract int getStock();
	
	@Override
	public abstract void addToStock(int stock, ApplianceCopy copy);
}
