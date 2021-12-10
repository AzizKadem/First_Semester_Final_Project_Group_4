package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.*;


class OrderCtrlTest {
	private Customer c;
	private CustomerCont CustCon;
	private OrderCtrl ctrl;
	private Date date;
	private Price price;
	private Product p;

	@BeforeEach
	void setUp() throws Exception {
		c = new Customer("1", "1", "1", "1", "1");
		price = new Price(date, 123);
		p = new Item("1", price, 12, "1", "1");
		ProductCont.getInstance().addProduct(p);
		ctrl = new OrderCtrl();
		CustomerCont.getInstance().addCustommer(c);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateOrder() {
		assertEquals(true, ctrl.createOrder("1"));
		assertEquals(c, ctrl.getCurrentOrder().getACustomer());
		
	}

	@Test
	void testCreateOrderline() {
		ctrl.createOrder("1");
		assertEquals(true, ctrl.createOrderline("1", 1));
		ArrayList<OrderLine> orderLines = new ArrayList<>();
		OrderLine orderLine = new ItemsOrderLine(10, p);
		orderLines.add(orderLine);
		assertEquals(123, ctrl.getTotal());
	}

	//@Test
	//void testFinishOrder() {
	//	fail("Not yet implemented");
	//}

}
