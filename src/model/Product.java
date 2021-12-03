package model;

public class Product {

	private String name;
	private Price price;
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
		this.price = price;
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
	public Price getPrice() {
		return price;
	}

	/**
	 * @return the barcode
	 */
	public int getBarcode() {
		return barcode;
	}

	
}
