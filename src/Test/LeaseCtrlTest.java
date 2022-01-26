package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.LeaseCtrl;
import exceptions.CustomerNotFoundException;
import exceptions.LeaseNotFoundException;
import exceptions.MachineNotFoundException;
import exceptions.NotCorrectCustomerException;
import model.Customer;
import model.CustomerCont;
import model.Lease;
import model.LeaseCont;
import model.Machine;
import model.MachineCont;

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
	void testSearchLease() throws NotCorrectCustomerException, LeaseNotFoundException {
		Lease l = new Lease(c, m);
		LeaseCont.getInstance().addLease(l);
		assertEquals(l, ctrl.searchLease(c, 1));
	}
	


	@Test
	void testConfirmLease() throws NotCorrectCustomerException, LeaseNotFoundException {
		assertEquals(true, ctrl.confirmLease(c, m));
		assertEquals(m ,ctrl.searchLease(c, 1).getMachine());
		LeaseCont.getInstance().emptyContainer();
		ctrl.removeLease(ctrl.searchLease(c, 1));
	}
	
	@Test
	void testRemoveLease() throws NotCorrectCustomerException, LeaseNotFoundException {
		ctrl.confirmLease(c, m);
		ctrl.removeLease(ctrl.searchLease(c, 1));
		assertEquals(0, LeaseCont.getInstance().getContainerSize());
	}

	

}
