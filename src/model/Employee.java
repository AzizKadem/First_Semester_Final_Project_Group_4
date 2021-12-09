package model;

public class Employee extends Staff{
	private int employeeId;
	
	public Employee(int workerID, String name, String cPR) {
		// TODO Auto-generated constructor stub
		super(workerID, name, cPR);
	}

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}
