package exceptions;

public class NotEnoughInStockException extends Exception {
	/**
	 * Get message about exception
	 * @return Message
	 */
	public String getMessage() {
		return "There is not enough products in stock.";
	}
}
