package model;

public class PackageLine {
	
	private Product aProduct;
	private int quantity;
	private ApplianceCopy aCopy;
	
	/**
	 * PackageLine constructor
	 * 
	 * @param aProduct the product of the line
	 * @param quantity the quantity of the product
	 */
	public PackageLine(Product aProduct, int quantity) {
		super();
		this.aProduct = aProduct;
		this.quantity = quantity;
		aCopy = null;
	}
	
	/**
	 * PackageLine constructor
	 * 
	 * @param aProduct the product of the line
	 * @param quantity the quantity of the product
	 */
	public PackageLine(Product aProduct, int quantity, ApplianceCopy aCopy) {
		super();
		this.aProduct = aProduct;
		this.quantity = quantity;
		this.aCopy = aCopy;
	}

	/**
	 * Get aProduct
	 * 
	 * @return the aProduct
	 */
	public Product getaProduct() {
		return aProduct;
	}

	/**
	 * Set aProduct
	 * 
	 * @param aProduct the aProduct to set
	 */
	public void setaProduct(Product aProduct) {
		this.aProduct = aProduct;
	}

	/**
	 * Get quantity
	 * 
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Set quantity
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Get aCopy
	 * 
	 * @return the aCopy
	 */
	public ApplianceCopy getaCopy() {
		return aCopy;
	}

	/**
	 * Set aCopy
	 * 
	 * @param aCopy the aCopy to set
	 */
	public void setaCopy(ApplianceCopy aCopy) {
		this.aCopy = aCopy;
	}
}
