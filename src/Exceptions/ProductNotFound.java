package Exceptions;

public class ProductNotFound extends IllegalArgumentException {
	private String key;
	
	public ProductNotFound(String key) {
		this.key = key;
	}

	/**
	 * Get message about exception
	 * @return Message
	 */
	public String getMessage() {
		return "The product with the barcode \'" + key + "\' doesn't exists";
	}

	/**
	 * Get key.
	 *
	 * @return key as String.
	 */
	public String getKey() {
	    return key;
	}
}

