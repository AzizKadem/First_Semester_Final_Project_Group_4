package model;

import java.util.ArrayList;

import javax.print.attribute.standard.Copies;

public class Appliance extends SingleProduct {
	private int generation;
	private int waranty;
	private String brand;
	private int id;
	private ArrayList<ApplianceCopy> applianceCopies;

	/**
	 * @param name the name of the appliance
	 * @param price the price of the appliance
	 * @param id the id
	 * @param generation the generation of the appliance
	 * @param waranty the warranty of the appliance
	 * @param brand the brand of the appliance
	 */
	public Appliance(String name, Price price, int id,
			int generation, int waranty, String brand) {
		super(name, price);
		this.waranty = waranty;
		this.brand = brand;
		applianceCopies = new ArrayList<>();
	}

	/**
	 * Get copy
	 * @param barcode The barcode we are searching by
	 * @return Found copy, null if not found
	 */
	public ApplianceCopy getCopyByBarcode(String barcode) {
		ApplianceCopy retVal = null;
		boolean found = false;
		int index = 0;

		while (index < applianceCopies.size() && !found) {
			if (applianceCopies.get(index).getBarcode().equals(barcode)) {
				retVal = applianceCopies.get(index);
				found = true;
			}
			else {
				index++;
			}
		}

		return retVal;
		
	}

	/**
	 * Add a copy to the list
	 * @param copy A copy to be adder
	 * @return True if the copy was added successfully
	 */
	public boolean addCopy(ApplianceCopy copy) {
		boolean retVal = false;

		if (applianceCopies.add(copy)) {
			retVal = true;
		}

		return retVal;
	}

	@Override
	public boolean isWithBarcode(String barcode) {
		boolean found = false;

		if (getCopyByBarcode(barcode) != null) {
			found = true;
		}

		return found;
	}

	/**
	 * Get stock
	 *
	 * @return stock as int
	 */
	@Override
	public int getStock() {
		int retVal = 0;
		for(ApplianceCopy copy:applianceCopies) {
			retVal += copy.getStock();
		}
		return retVal;
	}

	/**
	 * Add to the stock
	 */
	@Override
	public void addToStock(int stock, ApplianceCopy copy) {
		copy.setStock(copy.getStock() + stock);
	}

	@Override
	public int getNumberOfOrders() {
		int number = 0;
		for(ApplianceCopy copy:applianceCopies) {
			number += copy.getNumberOfOrders();
		}
		return number;
	}
}
