package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import model.Customer;
import model.CustomerCont;

class CustomerCtrlTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSearchCustomer() {
		Customer c = new Customer("1", "1", "1", "1", "1");
		CustomerCont.getInstance().addCustommer(c);
		assertEquals(c, CustomerCtrl.searchCustomer("1"));
	}
}
