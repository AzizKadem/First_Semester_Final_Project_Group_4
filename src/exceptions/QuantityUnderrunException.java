package exceptions;

public class QuantityUnderrunException extends IllegalArgumentException{

	public QuantityUnderrunException() {
	}

	/**
	 * Get message about exception
	 * @return Message
	 */
	public String getMessage() {
		return "The quantity must be higher than 0.";
	}
}