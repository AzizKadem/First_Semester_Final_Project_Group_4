package model;

public abstract class OrderLine {
	private int quantity;
	private double subTotal;
	private double discount;
	private Product aProduct;

	/**
	 * @param quantity
	 * @param aProduct
	 */
	public OrderLine(int quantity, Product aProduct) {
		this.quantity = quantity;
		this.aProduct = aProduct;
	}
	
	/**
	 * Calculate sub total price from the product
	 */
	public void calculateSubTotal() {
		subTotal = aProduct.getPrice() * quantity;
		
		if (quantity > 9) {
			discount = subTotal * 0.05;
			subTotal = subTotal * 0.95;
		}
	}

	/**
	 * Subtract quantity from the stock
	 */
	public abstract void subtractFromStock();

	/**
	 * Add a quantity to stock
	 */
	public abstract void addToStock();

	/**
	 * Get quantity.
	 *
	 * @return quantity as int.
	 */
	public int getQuantity() {
	    return quantity;
	}

	/**
	 * Set quantity.
	 *
	 * @param quantity the value to set.
	 */
	public void setQuantity(int quantity) {
	    this.quantity = quantity;
	}

	/**
	 * Get subTotal.
	 *
	 * @return subTotal as double.
	 */
	public double getSubTotal() {
	    return subTotal;
	}

	/**
	 * Set subTotal.
	 *
	 * @param subTotal the value to set.
	 */
	public void setSubTotal(double subTotal) {
	    this.subTotal = subTotal;
	}

	/**
	 * Get aProduct.
	 *
	 * @return aProduct as Product.
	 */
	public Product getAProduct() {
		return aProduct;
	}

	/**
	 * Get discount.
	 *
	 * @return discount as double.
	 */
	public double getDiscount() {
	    return discount;
	}
}
