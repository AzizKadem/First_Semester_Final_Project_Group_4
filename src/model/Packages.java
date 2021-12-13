package model;

import java.util.HashMap;
import java.util.Map;

public class Packages extends Product {

	private String barcode;
	private HashMap<Product, Integer> content;
	private HashMap<SingleProduct, Integer> neededAmount; //this map only contains the products as a key
	
	/**
	 * @param name the name of the package
	 */
	public Packages(String name, String barcode, Price price) {
		super(name, price);
		this.barcode = barcode;
		content = new HashMap<>();
		neededAmount = new HashMap<>();
	}
	
	/**
	 * Adds a product to the package, if it already exists then just increases 
	 * the value of the product by the amount
	 * @param p the product to be added
	 * @param amount the amount of the product which is added
	 */
	public void add(SingleProduct p, int amount) {
		addToNeededSinlgeProduct(p, amount);
		if(!content.containsKey(p)) {
			content.put(p, amount);
		}
		else {
			content.put(p, content.get(p) + amount);
		}
	}
	
	/**
	 * Adds a package to the package, if it already exists then just increases 
	 * the value of the package by the amount
	 * @param p the package to be added
	 * @param amount the amount of the package which is added
	 */
	public void add(Packages p, int amount) {
		addToNeededPackage(p, amount);
		if(!content.containsKey(p)) {
			content.put(p, amount);
		}
		else {
			content.put(p, content.get(p) + amount);
		}
	}
	
	/**
	 * Adds a product to the needed products, if the product already exist in the map
	 * then increases the value of the product by the amount
	 * @param p the product to be added
	 * @param amount the amount of the package which is added
	 */
	public void addToNeededSinlgeProduct(SingleProduct p, int amount) {
			if(!neededAmount.containsKey(p)) {
				neededAmount.put(p, amount);
			}
			else {
				neededAmount.put(p, neededAmount.get(p) + amount);
			}
	}
	
	
	/**
	 * Adds each of the products to the needed products that the package contains,
	 * if a product already exist in the map then increases the value of the 
	 * product by the amount
	 * @param p the product to be added
	 * @param amount the amount of the package which is added
	 */
	public void addToNeededPackage(Packages p, int amount) {
			for(Map.Entry<SingleProduct, Integer> element:p.getNeededAmount().entrySet()) {
				SingleProduct key = element.getKey();
				int value = element.getValue();
				addToNeededSinlgeProduct(key, value * amount);
			}
	}

	/**
	 * Get the amount of products that is needed for the package
	 * 
	 * @return the neededAmount
	 */
	public HashMap<SingleProduct, Integer> getNeededAmount() {
		return neededAmount;
	}

	/**
	 * Check if the stock has amount
	 * @param amount The amount of items to be compared
	 * @return True if stock has enough items
	 */
	@Override
	public boolean isEnoughInStock(int amount) {
		boolean retVal = true;
		for(Map.Entry<SingleProduct, Integer> element:neededAmount.entrySet()) {
			Product key = element.getKey();
			int value = element.getValue();
			if(!key.isEnoughInStock(value * amount)) {
				retVal = false;
			}
		}
		return retVal;
	}
	
	/**
	 * Get price.
	 * @return the price
	 */
	public double calculatePrice() {
		double retPrice = 0.0;
		for(Map.Entry<Product, Integer> element:content.entrySet()) {
			Product key = element.getKey();
			int value = element.getValue();
			retPrice += key.getPrice() * value;
		}
		return retPrice;
	}

	/**
	 * Get the content
	 * 
	 * @return the content
	 */
	public HashMap<Product, Integer> getContent() {
		return content;
	}

	/**
	 * Does this package contain the barcode
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
		int smallest = Integer.MAX_VALUE;
		for(Map.Entry<SingleProduct, Integer> element:neededAmount.entrySet()) {
			SingleProduct key = element.getKey();
			Integer value = element.getValue();
			int i = key.getStock()/value;
			if(i<smallest) {
				smallest = i;
			}
		}
		return smallest;
	}

	@Override
	public void setStock(int stock) {
		for(Map.Entry<SingleProduct, Integer> element:neededAmount.entrySet()) {
			SingleProduct key = element.getKey();
			Integer value = element.getValue();
			key.setStock(key.getStock() + stock * value);
		}
	}
	
}
