package exceptions;

public class NotCorrectCustomerException extends Exception {

	public NotCorrectCustomerException() {
		// TODO Auto-generated constructor stub
	}
	
	public String getMessage()
	{
		return "The lease doesn't match the customer";
	}

}
