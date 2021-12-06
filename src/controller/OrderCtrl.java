package controller;

import Exceptions.ProductNotFound;
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
	 * Find a product by barcode
	 * @param barcode The barcode of the product
	 * @return The found product
	 */
	public Product searchProduct(String barcode) {
		Product aProduct = productCtrl.searchProduct(barcode);

		return aProduct;
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
			if (OrderCont.getInstance().addOrder(currentOrder)) {
				retVal = true;
			}
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
			ProductNotFound {
		boolean	retVal = false;
		Product product = productCtrl.searchProduct(barcode);
		if (quantity < 1) {
			throw new QuantityUnderrunException();
		}
		else {
			if (product != null) {
				if (currentOrder.checkOrderForProduct(product)) {
					quantity += currentOrder.getQuantityOfOrderLine(product);
					currentOrder.deleteOrderLine(product);
					
				}
				if (product.isEnoughInStock(quantity)) {
					if (currentOrder.addOrderLine(new OrderLine(quantity, product))) {
						retVal = true;
					}
				}
			}
			else {
				throw new ProductNotFound(barcode);
			}
		}

		return retVal;
	}

	/**
	 * Finish the current order
	 * @return Receipt
	 */
	public String finishOrder() {
		if(currentOrder.isEmpty())
		{
			return "The order is empty, try again.";
		}
		else
		{
			currentOrder.getReceipt();
			staffCtrl.addTotal(currentOrder.getPrice());
			return currentOrder.getReceipt();
		}
	}
	
	public boolean isEmpty()
	{
		return currentOrder.isEmpty();
	}

	public String printInfo()	{
		return OrderCont.getInstance().printInfo();
	}
	
	public double getTotal() {
		return currentOrder.getPrice();
	}
	
	public String getProductsAndPrice() {
		return currentOrder.getProductsAndPrice();
	}
}