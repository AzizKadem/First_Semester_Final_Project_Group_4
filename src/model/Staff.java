package model;


public class Staff {
	
	private double total;
	private int workerID;
	private String name;
	private String phoneNumber;
	private String CPR;
	private String address;
	

	/**
	 * @param workerID
	 * @param name
	 * @param cPR
	 */
	public Staff(int workerID, String name, String cPR) {
		super();
		this.workerID = workerID;
		this.name = name;
		CPR = cPR;
		total = 0;
	}
	
	/**
	 * @param amount
	 */
	public void updateTotal(double amount) {
		total = total + amount;
	}

	/**
	 * @return
	 */
	public int getWorkerID() {
		return workerID;
	}

	/**
	 * @param workerID
	 */
	public void setWorkerID(int workerID) {
		this.workerID = workerID;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return
	 */
	public String getCPR() {
		return CPR;
	}

	/**
	 * @param cPR
	 */
	public void setCPR(String cPR) {
		CPR = cPR;
	}

	/**
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total
	 */
	public void setTotal(double total) {
		this.total = total;
	}
}
