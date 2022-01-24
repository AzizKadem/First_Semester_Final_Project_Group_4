package exceptions;

public class MachineNotFoundException extends Exception{
	/**
	 * Get message about exception
	 * @return Message
	 */
	public String getMessage() {
		return "The machine was not found.";
	}
}
