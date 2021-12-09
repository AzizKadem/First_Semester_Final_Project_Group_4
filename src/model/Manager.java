package model;

public class Manager extends Staff{
	private int managerId;
	
	public Manager(int workerID, String name, String cPR) {
		// TODO Auto-generated constructor stub
		super(workerID, name, cPR);
	}

	/**
	 * @return the managerId
	 */
	public int getManagerId() {
		return managerId;
	}

	/**
	 * @param managerId the managerId to set
	 */
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

}
