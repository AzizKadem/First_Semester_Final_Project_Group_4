package Exceptions;

public class EmptyOrder extends Exception {
	/**
	 * Get message about exception
	 * @return Message
	 */
	public String getMessage() {
		return "The order is empty.";
	}
}
