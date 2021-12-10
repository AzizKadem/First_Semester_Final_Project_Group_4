package controller;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	void testSearchCustomer() {
		
		assertEquals(true, ctrl.searchCustomer("1").equals(c));
	}

	@Test
	void testSearchMachine() {
		assertEquals(true, ctrl.searchMachine(2).equals(m2));
	}

	@Test
	void testSearchLease() {
		Lease l = new Lease(c, m);
		LeaseCont.getInsatnce().addLease(l);
		assertEquals(l, ctrl.searchLease(1));
	}
	


	@Test
	void testConfirmLease() {
		assertEquals(true, ctrl.confirmLease(c, m));
		assertEquals(m ,ctrl.searchLease(1).getMachine());
		LeaseCont.getInsatnce().emptyContainer();
		ctrl.removeLease(ctrl.searchLease(1));
	}
	
	@Test
	void testRemoveLease() {
		ctrl.confirmLease(c, m);
		ctrl.removeLease(ctrl.searchLease(1));
		assertEquals(0, LeaseCont.getInsatnce().getContainerSize());
	}

	

}
