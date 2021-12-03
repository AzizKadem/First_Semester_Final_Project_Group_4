package model;

import java.util.ArrayList;

public class ProductCont {

	private static ProductCont instance;
	private ArrayList<Product> products;
	
	/**
	 * ProductCont constructor
	 */
	private ProductCont() {
		products = new ArrayList<>();
	}
	
	/**
	 * Get instance of the singleton container
	 * @return The instance
	 */
	public static ProductCont getInstance() {
		if(instance == null) {
			instance = new ProductCont();
		}
		return instance;
	}
	
	/**
	 * Search for a product
	 * @param barcode the barcode of the product to search for
	 * @return The product with the corresponding barcode, null if there is no product with matching barcode
	 */
	public Product searchProduct(String barcode) {
		boolean found = false;
		Product retProduct = null;
		for(int i=0; !found && i<products.size();i++) {
			Product element = products.get(i);
			if(element.getBarcode().equals(barcode)) {
				retProduct = element;
			}
		}
		return retProduct;
	}
}
