package model;

public class Item extends SingleProduct {
	private String barcode;
	private String category;
	private int stock;
	
	/**
	 * @param name the name of the item
	 * @param price the price of the item
	 * @param stock the stock which the item has
	 * @param category the category in which the item belongs
	 * @param barcode the barcode of the item
	 */
	public Item(String name, Price price, int stock, String category, String barcode) {
		super(name, price);
		this.barcode = barcode;
		this.category = category;
		this.stock = stock;
	}

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
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public void addToStock(int stock, ApplianceCopy copy) {
		this.stock += stock;		
	} 

	@Override
	public int getNumberOfOrders() {
		return OrderCont.getInstance().getNumberOfProductsSold(ProductCont.getInstance().searchProduct(barcode));
	}

}
