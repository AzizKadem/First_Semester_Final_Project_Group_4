package controller;

import Exceptions.EmptyOrderException;
import Exceptions.ProductNotFoundException;
import Exceptions.QuantityUnderrunException;
import model.Customer;
import model.Order;
import model.OrderCont;
import model.OrderLine;
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
	 * Create order and add it to the container
	 * @param phone The phone number of the customer
	 * @return True if the order was successfully created
	 */
	public boolean createOrder(String phone) {
		Customer currentCustomer = customerCtrl.searchCustomer(phone);
		
		boolean retVal = false;
		if (currentCustomer != null) {
			currentOrder = new Order(currentCustomer);
			retVal = true;
		}

		return retVal;
	}
	
	/**
	 * Create order line and add it to the current order
	 * @param barcode The barcode of the product
	 * @param quantity Amount of the product ordered
	 * @return True if the order line was created successfully
	 * @throws QuantityUnderrunException
	 */
	public boolean createOrderline(String barcode, int quantity) throws QuantityUnderrunException,
			ProductNotFoundException {
		boolean	retVal = false;
		Product product = productCtrl.searchProduct(barcode);
		if (quantity < 1) {
			throw new QuantityUnderrunException();
		}
		else {
			if (product != null) {
				if (currentOrder.checkOrderForProduct(product)) {
					quantity += currentOrder.getQuantityOfOrderLine(product);
					currentOrder.addToStock(product);
					currentOrder.deleteOrderLine(product);
					
				}
				if (productCtrl.isEnoughInStock(product, quantity)) {
					if (currentOrder.addOrderLine(new OrderLine(quantity, product))) {
						retVal = true;
					}
				}
			}
			else {
				throw new ProductNotFoundException(barcode);
			}
		}

		return retVal;
	}

	/**
	 * Finish the current order
	 * @return Receipt
	 * @throws EmptyOrderException
	 */
	public boolean finishOrder() throws EmptyOrderException {
		boolean retVal = false;

		if(currentOrder.isEmpty()) {
			throw new EmptyOrderException();
		}
		else {
			if (OrderCont.getInstance().addOrder(currentOrder)) {
				staffCtrl.addTotal(currentOrder.getPrice());
				currentOrder = null;

				retVal = true;
			}
			
		}
		return retVal;
	}
	
	/**
	 * Cancel the current order
	 * @return Information about cancellation
	 */
	public void cancelOrder() {
		currentOrder.cancelOrder();
		currentOrder = null;
	}
	
	/**
	 * Check if the current order is empty
	 * @return True if the current order is empty
	 */
	public boolean isEmpty() {
		return currentOrder.isEmpty();
	}
	
	/**
	 * Get total price of the current order
	 * @return Price of the current order
	 */
	public double getTotal() {
		return currentOrder.getPrice();
	}

	/**
	 * Get currentOrder.
	 *
	 * @return currentOrder as Order.
	 */
	public Order getCurrentOrder() {
	    return currentOrder;
	}
}
