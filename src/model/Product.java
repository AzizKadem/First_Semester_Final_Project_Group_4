package model;

import java.util.ArrayList;

public abstract class Product {

	private String name;
	private ArrayList<Price> prices;
	private int stock;
	//private Department department;
	
	/**
	 * Product constructor
	 * @param name the name of the product
	 * @param price the price of the product
	 * @param stock the stock which the product has
	 * @param category the category of the product
	 * @param barcode the barcode of the product
	 */
	public Product(String name, Price price, int stock) {
		super();
		this.name = name;
		prices = new ArrayList<>();
		prices.add(price);
		this.stock = stock;
	}
	
	/**
	 * Check if the stock has amount
	 * @param amount The amount of items to be compared
	 * @return True if stock has enough items
	 */
	public boolean isEnoughInStock(int amount) {
		boolean retVal = false;
		if ((stock - amount) >= 0) {
			retVal = true;
		}
		return retVal;
	}
	
	/**
	 * Get name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get price.
	 * @return the price
	 */
	public double getPrice() {
		return prices.get(prices.size()-1).getPrice();
	}

	/**
	 * Get barcode.
	 * 
	 * @return the barcode
	 */
	public abstract String getBarcode();
	
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
}
