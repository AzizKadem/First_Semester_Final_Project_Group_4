package model;

public class Customer {
	
	private String name;
	private String phoneNumber;
	private String address;
	private String city;
	private String zipCode;
	
	/**
	 * Constructor for the customer
	 * @param name The name of the customer
	 * @param phoneNumber The phone number of the customer
	 * @param address The address of the customer
	 * @param city The city where the customer lives
	 * @param zipCode The zip code of the city
	 * @param discount Customers own discount
	 */
	public Customer(String name, String phoneNumber, String address, String city, String zipCode) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.zipCode = zipCode;
	}

	/**
	 * Get name of the customer
	 * 
	 * @return name as String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set name of the customer
	 * 
	 * @param name The name to be set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get customers phone number
	 * 
	 * @return Phone number as String
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Set customers phone number
	 * 
	 * @param phoneNumber Customers new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Get customer address
	 * 
	 * @return address as String
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Set customers address
	 * 
	 * @param address Customers new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Get city of the customer
	 * 
	 * @return city as String
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Set city of the customer
	 * 
	 * @param city as String
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Get customers zip code
	 * 
	 * @return zip code as String
	 */
	public String getZipCode() {
		return zipCode;
	}
	
	/**
	 * Set new zip code
	 * 
	 * @param zipCode New zip code
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
