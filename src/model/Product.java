package model;

public abstract class Product {

	private String name;
	
	/**
	 * Product constructor
	 * @param name the name of the product
	 */
	public Product(String name) {
		super();
		this.name = name;
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
	
	public abstract double getPrice();
	
	public abstract boolean isWithBarcode(String barcode);
	
	/**
	 * Get stock.
	 *
	 * @return stock as int.
	 */
	public abstract int getStock();
	
	public abstract void setStock(int stock);
	
}
