package model;

public class OrderLine {
	private int quantity;
	private double subTotal;
	private Product aProduct;
	private double discount;

	/**
	 * @param quantity
	 * @param aProduct
	 */
	public OrderLine(int quantity, Product aProduct) {
		this.quantity = quantity;
		this.aProduct = aProduct;
		subTotal = aProduct.getPrice() * quantity;
		if(quantity > 9) {
			discount = subTotal * 0.05;
			subTotal = subTotal * 0.95;
		}
	}

	/**
	 * Get info of the orderLine
	 * @return String about the info
	 */
	public String getInfo() {
		StringBuilder returnString = new StringBuilder();

		returnString.append(aProduct.getName());
		returnString.append("\t" + aProduct.getPrice());
		returnString.append(" x" + quantity);
		if(quantity < 10)
		{
			returnString.append(" " + subTotal);
		}
		else
		{
			returnString.append(" " + (subTotal + discount));
			returnString.append(" -" + discount);
			returnString.append(" " + subTotal);
		}
	
		return returnString.toString();
	}
	
	/**
	 * Subtract quantity from the stock
	 */
	public void subtractFromStock() {
		aProduct.setStock(aProduct.getStock() - quantity);
		System.out.println("Stock: " + aProduct.getStock());
	}

	/**
	 * Add a quantity to stock
	 */
	public void addToStock() {
		aProduct.setStock(aProduct.getStock() + quantity);
	}

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
