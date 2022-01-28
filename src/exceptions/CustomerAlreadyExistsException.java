package exceptions;

public class CustomerAlreadyExistsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7545175496465821372L;

	/**
	 * Get message about exception
	 * @return Message
	 */
	public String getMessage() {
		return "The customer with this phone number already exists.";
	}
}
