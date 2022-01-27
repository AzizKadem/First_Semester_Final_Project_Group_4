package exceptions;

public class MachineAlreadyLeasedException extends Exception{

	/**
	 * Get message about exception
	 * @return Message
	 */
	public String getMessage() {
		return "The machine had already been leased.";
	}
}
