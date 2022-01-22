package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.OrderCtrl;
import exceptions.CustomerNotFoundException;
import exceptions.NotEnoughInStockException;
import exceptions.ProductNotFoundException;
import exceptions.QuantityUnderrunException;
import model.Appliance;
import model.ApplianceCopy;
import model.Customer;
import model.CustomerCont;
import model.Date;
import model.Item;
import model.OrderCont;
import model.PackageLine;
import model.Packages;
import model.Price;
import model.Product;
import model.ProductCont;
import model.SingleProduct;


class OrderCtrlTest {
	private Customer customer;
	private OrderCtrl ctrl;
	private Date date;
	private Price price;
	private Product item;
	private Appliance appliance;
	private ApplianceCopy appCopy;
	private Packages aPackage;
	private PackageLine line1;
	private PackageLine line2;
	
	private int stock;

	@BeforeEach
	void setUp() throws Exception {
		
		customer = new Customer("1", "1", "1", "1", "1");
		price = new Price(date, 10);
		
		stock = 10;
		
		item = new Item("1", price, stock, "1", "1");
		
		
		appliance = new Appliance("2", price, 2, 2, 2, "2");
		appCopy = new ApplianceCopy("2", "2", "2", stock);
		
		appliance.addCopy(appCopy);
		
		line1 = new PackageLine(item, 1);
		line2 = new PackageLine(appliance, 1, appCopy);
		
		aPackage = new Packages("3", "3", price);
		
		aPackage.add(line1);
		aPackage.add(line2);
		
		
		
		ProductCont.getInstance().addProduct(item);
		ProductCont.getInstance().addProduct(appliance);
		ProductCont.getInstance().addProduct(aPackage);
		
		ctrl = new OrderCtrl();
		CustomerCont.getInstance().addCustommer(customer);
	}

	@AfterEach
	void tearDown() throws Exception {
		ProductCont.getInstance().emptyContainer();
		CustomerCont.getInstance().emptyContainer();
	}

	@Test
	void testCreateOrder() throws CustomerNotFoundException {
		assertEquals(true, ctrl.createOrder("1"));
		assertEquals(customer, ctrl.getCurrentOrder().getACustomer());
		
	}

	@Test
	void testCreateOrderlineItem() throws QuantityUnderrunException,
			ProductNotFoundException, NotEnoughInStockException, CustomerNotFoundException {
		ctrl.createOrder("1");
		
		assertEquals(true, ctrl.createOrderline("1", 1));
		assertEquals(price.getPrice(), ctrl.getTotal());
		assertEquals((stock - 1), item.getStock());
	}
	
	@Test
	void testCancelOrder() throws QuantityUnderrunException,
			ProductNotFoundException, NotEnoughInStockException, CustomerNotFoundException {
		ctrl.createOrder("1");
		
		assertEquals(true, ctrl.createOrderline("1", 1));
		assertEquals(stock - 1, item.getStock());
		
		ctrl.cancelOrder();
		
		assertEquals(0, OrderCont.getInstance().getOrders().size());
		assertEquals(stock, item.getStock());
	}
	
	@Test
	void testCreateOrderLineAppliance() throws QuantityUnderrunException,
			ProductNotFoundException, NotEnoughInStockException, CustomerNotFoundException {
		ctrl.createOrder("1");
		
		assertEquals(true, ctrl.createOrderline("2", 1));
		assertEquals(stock - 1, appCopy.getStock());
	}
	
	@Test
	void testCreateOrderLinePackage() throws QuantityUnderrunException,
			ProductNotFoundException, NotEnoughInStockException, CustomerNotFoundException {
		ctrl.createOrder("1");
	
		assertEquals(true, ctrl.createOrderline("3", 1));
		assertEquals(stock - 1, item.getStock());
		assertEquals(stock - 1, appCopy.getStock());
		assertEquals(stock - 1, aPackage.getStock());
	}
	
}
