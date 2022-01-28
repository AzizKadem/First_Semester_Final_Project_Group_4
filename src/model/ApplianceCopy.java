package model;

public class ApplianceCopy {
	private String color;
	private String state;
	private String barcode;
	private int stock;
	
	public ApplianceCopy(String color, String state, String barcode, int stock) {
		this.color = color;
		this.state = state;
		this.barcode = barcode;
		this.stock = stock;
	}
	

	/**
	 * Get color.
	 *
	 * @return color as String.
	 */
	public String getColor() {
	    return color;
	}

	/**
	 * Get state.
	 *
	 * @return state as String.
	 */
	public String getState() {
	    return state;
	}

	/**
	 * Get barcode.
	 *
	 * @return barcode as String.
	 */
	public String getBarcode() {
	    return barcode;
	}
	
	/**
	 * Check if the stock has amount
	 * @param amount The amount of items to be compared
	 * @return True if stock has enough items
	 */
	public boolean isEnoughInStock(int amount) {
		boolean retVal = false;
		if ((getStock() - amount) >= 0) {
			retVal = true;
		}
		return retVal;
	}

	/**
	 * Get stock.
	 *
	 * @return stock as int.
	 */
	public int getStock() {
	    return stock;
	}

	/**
	 * Set stock.
	 *
	 * @param stock the value to set.
	 */
	public void setStock(int stock) {
	    this.stock = stock;
	}
	
	public int getNumberOfOrders() {
		return OrderCont.getInstance().getNumberOfProductsSold(ProductCont.getInstance().searchProduct(barcode));
	}
}
