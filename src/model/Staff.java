package model;


public class Staff {
	
	private double total;
	private int workerID;
	private String name;
	private String phoneNumber;
	private String CPR;
	private String address;

	private String password;
	private String userName;
	
	private boolean isManager;

	/**
	 * Staff constructor
	 */
	public Staff(int workerID, String name, String cPR, String userName,
			String password, boolean isManager) {
		this.workerID = workerID;
		this.name = name;
		
		this.password = password;
		this.userName = userName;

		this.isManager = isManager;
		CPR = cPR;
		total = 0;
	}

	/**
	 * Set new log in password
	 * @param userName the name of the user
	 * @param oldPassword the password to be changed
	 * @param newPassword the new password
	 */
	public boolean setNewPassword(String userName, String oldPassword, String newPassword) {
		boolean retVal = false;

		if (checkLogIn(userName, oldPassword)) {
			password = newPassword;
			retVal = true;
		}
		
		return retVal;
	}

	/**
	 * Check if the log in is correct
	 * @param userName The user name
	 * @param password The password
	 * @return True if the user name and the password are correct
	 */
	public boolean checkLogIn(String userName, String password) {
		boolean retVal = false;

		if (this.password.equals(password)) {
			if (this.userName.equals(userName)) {
				retVal = true;
			}
		}

		return retVal;
	}
	
	/**
	 * Add to total by amount
	 * @param amount The amount to be added to the total
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
	
	public boolean isManager() {
		return isManager;
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
	
	public void setIsManager(boolean isManager) {
		this.isManager = isManager;
	}
}
