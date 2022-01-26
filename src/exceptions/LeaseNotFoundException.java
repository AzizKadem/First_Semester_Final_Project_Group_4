package exceptions;

public class LeaseNotFoundException extends Exception {

	public LeaseNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public String getMessage() {
		return "The lease was not found.";
	}
}
