package exceptions;

public class CustomerNotFoundException extends Exception {
	/**
	 * Get message about exception
	 * @return Message
	 */
	public String getMessage() {
		return "The customer was not found.";
	}
}