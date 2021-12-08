package model;

public class Item extends Product {
	private String barcode;
	private String category;
	
	public Item(String name, Price price, int stock, String category, String barcode) {
		super(name, price, stock);
		this.barcode = barcode;
		this.category = category;
	}

	@Override
	public String getBarcode() {
		return barcode;
	}

}
