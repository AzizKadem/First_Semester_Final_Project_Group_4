package model;

public class Staff {
	
	private double total;
	private int workerID;
	private String name;
	private String phoneNumber;
	private String CPR;
	private String address;
	

	public Staff(int workerID, String name, String cPR) {
		super();
		this.workerID = workerID;
		this.name = name;
		CPR = cPR;
		total = 0;
	}
	
	public void updateTotal(double amount) {
		total = total + amount;
	}

	public int getWorkerID() {
		return workerID;
	}

	public void setWorkerID(int workerID) {
		this.workerID = workerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCPR() {
		return CPR;
	}

	public void setCPR(String cPR) {
		CPR = cPR;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
