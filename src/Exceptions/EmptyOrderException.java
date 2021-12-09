package Exceptions;

public class EmptyOrderException extends Exception {
	/**
	 * Get message about exception
	 * @return Message
	 */
	public String getMessage() {
		return "The order is empty.";
	}
}
