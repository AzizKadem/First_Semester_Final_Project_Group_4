package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import controller.CustomerCtrl;
import exceptions.CustomerNotFoundException;
import model.Customer;
import model.CustomerCont;

class CustomerCtrlTest {

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
	public void testSearchCustomer() throws CustomerNotFoundException {
		Customer c = new Customer("1", "1", "1", "1", "1");
		CustomerCont.getInstance().addCustommer(c);
		CustomerCtrl ctrl = new CustomerCtrl();
		assertEquals(c, ctrl.searchCustomer("1"));
	}
}
