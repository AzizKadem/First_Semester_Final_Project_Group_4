package controller;

import model.Order;
import model.OrderLine;
import model.OrderCont;

import model.Product;

public class OrderCtrl {
	private CustomerCtrl customerCtrl;
	private ProductCtrl productCtrl;
	private StaffCtrl staffCtrl;
	private Order currentOrder;


	public OrderCtrl() {
		customerCtrl = new CustomerCtrl();
		productCtrl = new ProductCtrl();
		staffCtrl = new StaffCtrl();
	}

	/**
	 * Find a product by barcode
	 * @param barcode The barcode of the product
	 * @return The found product
	 */
	public Product searchProduct(int barcode) {
		Product aProduct = productCtrl.searchProduct(barcode);

		return aProduct;
	}

	/**
	 * Create order and add it to the container
	 * @param phone The phone number of the customer
	 * @return True if the order was successfully created
	 */
	public boolean createOrder(String phone) {
		currentOrder = new Order(customerCtrl.searchCustomer(phone));
		boolean retVal = false;
		if (OrderCont.getInstance().addOrder(currentOrder)) {
			retVal = true;
		}

		return retVal;
	}
	
	/**
	 * Create order line and add it to the current order
	 * @param quantity Amount of the product ordered
	 * @param barcode The barcode of the product
	 * @return True if the order line was created successfully
	 */
	public boolean createOrderline(int quantity, int barcode) {
		boolean	retVal = false;
		if (currentOrder.addOrderLine(new OrderLine(quantity, productCtrl.searchProduct(barcode)))) {
			retVal = true;
		}

		return retVal;
	}

	/**
	 * Finish the current order
	 * @return Receipt
	 */
	public String finishOrder() {
		currentOrder.finishOrder();
		staffCtrl.addTotal(currentOrder.getTotalPrice());
		return currentOrder.getReceipt();
	}

}
