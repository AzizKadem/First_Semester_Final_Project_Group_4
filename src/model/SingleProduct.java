package model;

import java.util.ArrayList;

public abstract class SingleProduct extends Product{

	private ArrayList<Price> prices;
	//private Department department;
	
	/**
	 * SingleProduct constructor
	 * @param name the name of the product
	 * @param price the price of the product
	 */
	public SingleProduct(String name, Price price) {
		super(name);
		prices = new ArrayList<>();
		prices.add(price);
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
	 * Get price.
	 * @return the price
	 */
	@Override
	public double getPrice() {
		return prices.get(prices.size()-1).getPrice();
	}

	public abstract boolean isWithBarcode(String barcode);

	/**
	 * Change the current price.
	 *  
	 * @param newPrice the new of the product
	 * @return true if the change was successful
	 */
	public boolean changePrice(Price newPrice) {
		return prices.add(newPrice);
	}

	

	/**
	 * Get stock.
	 *
	 * @return stock as int.
	 */
	public abstract int getStock();
	
	/**
	 * Set stock
	 * 
	 * @param Stock new stock
	 */
	public abstract void setStock(int stock);
}
