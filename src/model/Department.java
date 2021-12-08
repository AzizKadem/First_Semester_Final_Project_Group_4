package model;

public class Department {
	
	private String CVR;
	private String address;
	private String warehouse;

	public Department() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the cVR
	 */
	public String getCVR() {
		return CVR;
	}

	/**
	 * @param cVR the cVR to set
	 */
	public void setCVR(String cVR) {
		CVR = cVR;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the warehouse
	 */
	public String getWarehouse() {
		return warehouse;
	}

	/**
	 * @param warehouse the warehouse to set
	 */
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

}
