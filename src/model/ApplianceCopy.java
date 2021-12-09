package model;

public class ApplianceCopy {
	private String color;
	private String state;
	private String barcode;
	
	public ApplianceCopy(String color, String state, String barcode) {
		this.color = color;
		this.state = state;
		this.barcode = barcode;
	}
	

	/**
	 * Get color.
	 *
	 * @return color as String.
	 */
	public String getColor() {
	    return color;
	}

	/**
	 * Get state.
	 *
	 * @return state as String.
	 */
	public String getState() {
	    return state;
	}

	/**
	 * Get barcode.
	 *
	 * @return barcode as String.
	 */
	public String getBarcode() {
	    return barcode;
	}
}
