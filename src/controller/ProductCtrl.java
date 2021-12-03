package controller;

import model.Product;
import model.ProductCont;

public class ProductCtrl {

	public ProductCtrl() {
		
	}
	
	public Product searchProduct(int barcode) {
		return ProductCont.getInstance().searchProduct(barcode);
	}
}
