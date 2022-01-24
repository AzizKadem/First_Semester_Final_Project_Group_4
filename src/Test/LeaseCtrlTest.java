package Test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.LeaseCtrl;
import exceptions.CustomerNotFoundException;
import exceptions.MachineNotFoundException;
import model.*;

class LeaseCtrlTest {
	private Customer c;
	private Machine m;
	private Machine m2;
	private LeaseCtrl ctrl;

	@BeforeEach
	void setUp() throws Exception {
		c = new Customer("1", "1", "1", "1", "1");
		CustomerCont.getInstance().addCustommer(c);
		m = new Machine(1, "1");
		m2 = new Machine(2, "1");
		MachineCont.getInstance().addMachine(m);
		MachineCont.getInstance().addMachine(m2);
		ctrl = new LeaseCtrl();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSearchCustomer() throws CustomerNotFoundException {
		assertEquals(true, ctrl.searchCustomer("1").getPhoneNumber().equals(c.getPhoneNumber()));
	}

	@Test
	void testSearchMachine() throws MachineNotFoundException {
		assertEquals(true, ctrl.searchMachine(2).getName().equals(m2.getName()));
	}

	@Test
	void testSearchLease() {
		Lease l = new Lease(c, m);
		LeaseCont.getInstance().addLease(l);
		assertEquals(l, ctrl.searchLease(1));
	}
	


	@Test
	void testConfirmLease() {
		assertEquals(true, ctrl.confirmLease(c, m));
		assertEquals(m ,ctrl.searchLease(1).getMachine());
		LeaseCont.getInstance().emptyContainer();
		ctrl.removeLease(ctrl.searchLease(1));
	}
	
	@Test
	void testRemoveLease() {
		ctrl.confirmLease(c, m);
		ctrl.removeLease(ctrl.searchLease(1));
		assertEquals(0, LeaseCont.getInstance().getContainerSize());
	}

	

}
