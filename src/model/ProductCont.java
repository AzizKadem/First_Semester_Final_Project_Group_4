package model;

import java.util.ArrayList;

public class ProductCont {

	private static ProductCont instance;
	private ArrayList<Product> products;
	
	private ProductCont() {
		products = new ArrayList<>();
	}
	
	public static ProductCont getInstance() {
		if(instance == null) {
			instance = new ProductCont();
		}
		return instance;
	}
	
	public Product searchProduct(int barcode) {
		boolean found = false;
		Product retProduct = null;
		for(int i=0; !found && i<products.size();i++) {
			Product element = products.get(i);
			if(element.getBarcode() == barcode) {
				retProduct = element;
			}
		}
		return retProduct;
	}
}
