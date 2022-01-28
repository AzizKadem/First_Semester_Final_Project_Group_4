package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Packages extends Product {

	private String barcode;
	private ArrayList<PackageLine> lines;
	private HashMap<SingleProduct, Integer> neededAmount; //this map only contains the products as a key
	
	/**
	 * @param name the name of the package
	 */
	public Packages(String name, String barcode, Price price) {
		super(name, price);
		this.barcode = barcode;
		lines = new ArrayList<>();
		neededAmount = new HashMap<>();
	}
	
	/**
	 * Add a package line to the package
	 * @param p The package line to be added
	 * @return True if the package line was successfully added
	 */
	public boolean add(PackageLine p) {
		Product product = p.getaProduct();
		if(product.getClass().isAssignableFrom(Packages.class)) {
			addToNeededPackage((Packages)p.getaProduct(), p.getQuantity());
		}
		else {
			addToNeededSinlgeProduct((SingleProduct)p.getaProduct(), p.getQuantity());
		}
		boolean retVal = false;
		if(lines.add(p)) {
			retVal = true;
		}
		
		return retVal;
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
	 * Finds the package line which contains the product
	 * 
	 * @param p the product to search for
	 * @return the PackageLine which contains the product, null if there is no PackageLine 
	 * containing the product
	 */
	public PackageLine findProductInLines(Product p) {
		boolean found = false;
		PackageLine retVal = null;
		for(int i = 0; !found && i<lines.size(); i++) {
			PackageLine element = lines.get(i);
			if(element.getaProduct().equals(p)) {
				found = true;
				retVal = element;
			}
		}
		return retVal;
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
		for(PackageLine element:lines) {
			retPrice += element.getaProduct().getPrice()*element.getQuantity();
		}
		return retPrice*0.9;
	}

	/**
	 * Get the lines
	 * 
	 * @return the lines
	 */
	public ArrayList<PackageLine> getLines() {
		return lines;
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
	public void addToStock(int stock, ApplianceCopy copy) {
		for(PackageLine element:lines) {
			element.getaProduct().addToStock(element.getQuantity()*stock, element.getaCopy());
		}
	}

	@Override
	public int getNumberOfOrders() {
		return OrderCont.getInstance().getNumberOfProductsSold(ProductCont.getInstance().searchProduct(barcode));
	}
	
}
