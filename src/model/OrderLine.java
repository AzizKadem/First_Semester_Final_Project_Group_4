package model;

public class OrderLine {
	private int quantity;
	private double subTotal;
	private Product aProduct;

	public OrderLine(int quantity, Product aProduct) {
		this.quantity = quantity;
		this.aProduct = aProduct;
		subTotal = aProduct.getPrice() * quantity;
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
		returnString.append(" " + subTotal);

		return returnString.toString();
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
}
