package controller;

import java.util.ArrayList;

import model.Appliance;
import model.Item;
import model.Packages;
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
	 * @return The product with the corresponding barcode, null if not found
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
	public boolean isEnoughInStock(String barcode, int quantity) {
		boolean retVal = false;
		
		Product foundProduct = searchProduct(barcode);
		
		//check if the product is an appliance
		if (foundProduct.getClass().isAssignableFrom(Appliance.class)) {
			retVal = ((Appliance)foundProduct).getCopyByBarcode(barcode).isEnoughInStock(quantity);
		}
		
		//check if the product is an item
		else if (foundProduct.getClass().isAssignableFrom(Item.class)) {
			retVal = ((Item)foundProduct).isEnoughInStock(quantity);
		}
		
		//else it is a package
		else {
			retVal = ((Packages)foundProduct).isEnoughInStock(quantity);
		}

		return retVal;
	}
	
	/**
	 * @return a list of products
	 */
	public ArrayList<Product> getProducts() {
		return ProductCont.getInstance().getProducts();
	}
}
