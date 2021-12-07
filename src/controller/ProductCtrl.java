package controller;

import model.Product;
import model.ProductCont;

public class ProductCtrl {
	/**
	 * ProductCtrl constructor
	 */
	public ProductCtrl() {
		
	}

	/**
	 * Search for a product
	 * @param barcode the barcode of the product to search for
	 * @return The product with the corresponding barcode, null if there is no product with matching barcode
	 */
	public Product searchProduct(String barcode) {
		return ProductCont.getInstance().searchProduct(barcode);
	}

	/**
	 * Check if the product has enough quantity in stock
	 * @param aProduct A product to be checked
	 * @param quantity Quantity to be checked
	 * @return True if the quantity is enough
	 */
	public boolean isEnoughInStock(Product aProduct, int quantity) {
		boolean retVal = false;
		
		if (aProduct.isEnoughInStock(quantity)) {
			retVal = true;
		}

		return retVal;
	}
}
