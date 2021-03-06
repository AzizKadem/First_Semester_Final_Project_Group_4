package controller;

import exceptions.CustomerNotFoundException;
import exceptions.EmptyOrderException;
import exceptions.NotEnoughInStockException;
import exceptions.ProductNotFoundException;
import exceptions.QuantityUnderrunException;
import model.Appliance;
import model.AppliancesOrderLine;
import model.Customer;
import model.Item;
import model.ItemsOrderLine;
import model.Order;
import model.OrderCont;
import model.OrderLine;
import model.PackageOrderLine;
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
	public boolean createOrder(String phone) throws CustomerNotFoundException {
		Customer currentCustomer = customerCtrl.searchCustomer(phone);
		
		boolean retVal = false;
		if (currentCustomer != null) {
			currentOrder = new Order(currentCustomer);
			retVal = true;
		}
		else {
			throw new CustomerNotFoundException();
		}

		return retVal;
	}
	
	/**
	 * Create order line and add it to the current order
	 * @param barcode The barcode of the product
	 * @param quantity Amount of the product ordered
	 * @return True if the order line was created successfully
	 * @throws QuantityUnderrunException
	 * @throws NotEnoughInStockException 
	 * @throws ProductNotFoundException
	 */
	public boolean createOrderline(String barcode, int quantity) throws QuantityUnderrunException,
			ProductNotFoundException, NotEnoughInStockException {
		boolean	retVal = false;
		Product product = productCtrl.searchProduct(barcode);

		//check if the quantity is not 0 or negative
		if (quantity < 1) {
			throw new QuantityUnderrunException();
		}
		else {
			//check if product is not null
			if (product != null) {
				
				//check if there is enough products in stock
				if (productCtrl.isEnoughInStock(barcode, quantity)) {
					
					//check if the product is already ordered, if so merge the order line
					if (currentOrder.checkOrderForProduct(product)) {
						quantity += currentOrder.getQuantityOfOrderLine(product);

						currentOrder.addToStock(product);
						currentOrder.deleteOrderLine(product);
						
					}
					
					OrderLine orderLine = null;
					
					//check if the product is an appliance
					if (product.getClass().isAssignableFrom(Appliance.class)) {
						orderLine = new AppliancesOrderLine(quantity, product, barcode);
					}
					
					//check if the product is an item
					else if (product.getClass().isAssignableFrom(Item.class)){
						orderLine = new ItemsOrderLine(quantity, product);
					}
					
					//else it is a package
					else {
						orderLine = new PackageOrderLine(quantity, product);
					}
					
					//check if the order line was added successfully
					if (currentOrder.addOrderLine(orderLine)) {
						retVal = true;
					}
				}
				else {
					throw new NotEnoughInStockException();
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

		//check if the order is empty
		if (currentOrder.isEmpty()) {
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
