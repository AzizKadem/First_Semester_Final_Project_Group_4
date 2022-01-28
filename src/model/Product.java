package model;

import java.util.ArrayList;

public abstract class Product {

	private String name;
	private ArrayList<Price> prices;
	
	/**
	 * Product constructor
	 * @param name the name of the product
	 */
	public Product(String name, Price price) {
		super();
		this.name = name;
		prices = new ArrayList<>();
		prices.add(price);
	}

	/**
	 * Get name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	
	public abstract boolean isEnoughInStock(int amount);
	
	/**
	 * Get price.
	 * @return the price
	 */
	public double getPrice() {
		return prices.get(prices.size()-1).getPrice();
	}
	
	/**
	 * Get price.
	 * @return the price
	 */
	public ArrayList<Price> getPrices() {
		return prices;
	}
	
	public abstract boolean isWithBarcode(String barcode);
	
	/**
	 * Get stock.
	 *
	 * @return stock as int.
	 */
	public abstract int getStock();
	
	public abstract void addToStock(int stock, ApplianceCopy copy);
	
	/**
	 * @return the number of products sold all in all
	 */
	public abstract int getNumberOfOrders();
	
}
