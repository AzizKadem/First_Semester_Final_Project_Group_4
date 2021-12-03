package model;

import java.util.ArrayList;

public class Product {

	private String name;
	private ArrayList<Price> prices;
	private int stock;
	//private Department department;
	private String category;
	private int barcode;
	
	/**
	 * @param name
	 * @param price
	 * @param stock
	 * @param category
	 * @param barcode
	 */
	public Product(String name, Price price, int stock, String category, int barcode) {
		super();
		this.name = name;
		prices.add(price);
		this.stock = stock;
		this.category = category;
		this.barcode = barcode;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return prices.get(prices.size()-1).getPrice();
	}

	/**
	 * @return the barcode
	 */
	public int getBarcode() {
		return barcode;
	}
	
	public boolean changePrice(Price price) {
		return prices.add(price);
	}

	
}
