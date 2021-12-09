package model;

public class Appliance extends Product {
	private int generation;
	private int waranty;
	private String brand;
	private ApplianceCopy applianceCopy;

	public Appliance(String name, Price price, int stock,
			int generation, int waranty, String brand) {
		super(name, price, stock);
		this.waranty = waranty;
		this.brand = brand;
	}

	@Override
	public String getBarcode() {
		// TODO Auto-generated method stub
		return null;
	}

}
