package model;

import java.util.ArrayList;

public class Product {

	private String name;
	private ArrayList<Price> prices;
	private int stock;
	//private Department department;
	private String category;
	private String barcode;
	
	/**
	 * Product constructor
	 * @param name the name of the product
	 * @param price the price of the product
	 * @param stock the stock which the product has
	 * @param category the category of the product
	 * @param barcode the barcode of the product
	 */
	public Product(String name, Price price, int stock, String category, String barcode) {
		super();
		this.name = name;
		prices.add(price);
		this.stock = stock;
		this.category = category;
		this.barcode = barcode;
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
	public String getBarcode() {
		return barcode;
	}
	
	/**
	 * Change the current price.
	 *  
	 * @param newPrice the new of the product
	 * @return true if the change was successful
	 */
	public boolean changePrice(Price newPrice) {
		return prices.add(newPrice);
	}

	
}
