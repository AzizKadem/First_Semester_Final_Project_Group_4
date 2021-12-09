package JTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import controller.*;
import model.*;

class JUnitTestTest {

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
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSearchCustomer() {
		Customer c = new Customer("1", "1", "1", "1", "1");
		CustomerCont.getInstance().addCustommer(c);
		assertEquals(c, CustomerCtrl.searchCustomer("1"));
	}
}
