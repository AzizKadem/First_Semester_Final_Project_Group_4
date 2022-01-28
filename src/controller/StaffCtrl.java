package controller;

import java.util.ArrayList;

import model.Customer;
import model.Product;
import model.Staff;
import model.StaffCont;

public class StaffCtrl {
	private static Staff loged;	
	private CustomerCtrl customerCtrl;
	private ProductCtrl productCtrl;
	
	public StaffCtrl() {
		//for now
		productCtrl = new ProductCtrl();
		customerCtrl = new CustomerCtrl();
	}
	
	/**
	 * Add a total amount to the staff
	 * @param amount The amount to be added
	 */
	public void addTotal(double amount) {
		loged.updateTotal(amount);
	}

	/**
	 * Log in to the system
	 * @param userName The user name of the staff
	 * @param password The password of the staff
	 * @return True if the log in information was correct
	 */
	public boolean logIn(String userName, String password) {
		boolean retVal = false;
		Staff staff = StaffCont.getInstance().getStaffLogin(userName, password);

		if (staff != null) {
			loged = staff;
			retVal = true;
		}

		return retVal;
	}

	/**
	 * Get list of all staff
	 * @return ArrayList<Staff> List of all staff
	 */
	public ArrayList<Staff> getStaffList() {
		return StaffCont.getInstance().getStaffList();
	}
	
	/**
	 * Return a list of all the customers for the statistics
	 * @return a list of customers
	 */
	public ArrayList<Customer> generateCustomerStatistics() {
		return customerCtrl.getCustomers();
	}
	
	/**
	 * Return a list of all the products for the statistics
	 * @return a list of products
	 */
	public ArrayList<Product> generateProductStatistics() {
		return productCtrl.getProducts();
	}
}
